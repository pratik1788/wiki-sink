package com.ps.wikisink.consumer;

import com.ps.wikisink.entity.WikiValidDataEntity;
import com.ps.wikisink.event.EventProducer;
import com.ps.wikisink.pojo.EventNotification;
import com.ps.wikisink.pojo.WikiData;
import com.ps.wikisink.repository.WikiValidDataRepository;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WikiDataConsumer {

    @Autowired
    private WikiValidDataRepository repository;

    @Autowired
    private EventProducer eventProducer;

    private List<WikiValidDataEntity> dataHolder= new ArrayList<>();


    @KafkaListener(topics = "${application.data.consumer.topic}", groupId = "${application.data.consumer.group-id}")
    public void consume(byte[] message,  @Header("kafka_receivedMessageKey") String messageKey) throws IOException {
        SpecificDatumReader<WikiData> reader = new SpecificDatumReader<WikiData>(WikiData.getClassSchema());
        Decoder decoder = DecoderFactory.get().binaryDecoder(message, null);
        WikiData wikidata = reader.read(null, decoder);
        dataHolder.add(WikiValidDataEntity.builder()
                .dataMilestone(wikidata.getYearMonthDay())
                .hour(wikidata.getHourOfDay())
                .language(wikidata.getLanguage())
                .pageName(wikidata.getPageName())
                .nonUniqueViews(wikidata.getNonUniqueViews())
                .byteTransferred(wikidata.getBytesTransferred())
                .build());
        if(dataHolder.size() == 50000) {
            repository.saveAll(dataHolder).blockLast();
            dataHolder=new ArrayList<>();
        }
        String[] fileNameRow= messageKey.split("~");
        if(Integer.parseInt(fileNameRow[1]) % 100000 == 0){
            eventProducer.sendMessage(EventNotification.newBuilder()
            .setFileName(fileNameRow[0]).setEventName(fileNameRow[0])
            .setDetails("No of Message Processed"+ fileNameRow[1])
            .build()
            );
        }
    }
}