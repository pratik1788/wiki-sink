package com.ps.wikisink.consumer;

import com.ps.wikisink.entity.WikiValidDataEntity;
import com.ps.wikisink.event.EventProcessor;
import com.ps.wikisink.pojo.WikiDataCollection;
import com.ps.wikisink.repository.WikiValidDataRepository;
import com.ps.wikisink.service.WikiDataFilter;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WikiDataConsumer {

    private static final Logger logger = LoggerFactory.getLogger(WikiDataConsumer.class);

    @Autowired
    private WikiValidDataRepository repository;

    @Autowired
    private EventProcessor eventProcessor;

    @Autowired
    private WikiDataFilter wikiDataFilter;

    private SpecificDatumReader<WikiDataCollection> reader = new SpecificDatumReader<WikiDataCollection>(WikiDataCollection.getClassSchema());
    private List<WikiValidDataEntity> dataHolder= new ArrayList<>();

    @KafkaListener(topics = "${application.data.consumer.topic}", groupId = "${application.data.consumer.group-id}")
    public void consume(byte[] message,  @Header("kafka_receivedMessageKey") String messageKey) throws IOException {
        String typeFileNameDataCountFromKey[]=messageKey.split("~");
        eventProcessor.processEvent(typeFileNameDataCountFromKey);
        if(typeFileNameDataCountFromKey[0].equals("DATA")) {
            Decoder decoder = DecoderFactory.get().binaryDecoder(message, null);
            WikiDataCollection wikiDataCollection = reader.read(null, decoder);
            repository.saveAll(wikiDataCollection.getWikiDataList().stream().filter(e -> wikiDataFilter.isValidRecord(e)).map(e -> WikiValidDataEntity.builder()
                    .dataMilestone(e.getYearMonthDay())
                    .hour(e.getHourOfDay())
                    .language(e.getLanguage())
                    .pageName(e.getPageName())
                    .nonUniqueViews(e.getNonUniqueViews())
                    .byteTransferred(e.getBytesTransferred())
                    .recordId(e.getRecordId())
                    .build()).collect(Collectors.toList())).blockLast();
        }
    }
}

