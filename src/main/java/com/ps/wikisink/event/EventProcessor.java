package com.ps.wikisink.event;

import com.ps.wikisink.enums.EvenetName;
import com.ps.wikisink.pojo.EventNotification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;

@Service
public class EventProcessor {
    private static final Logger logger = LoggerFactory.getLogger(EventProcessor.class);
    @Autowired
    private EventProducer eventProducer;

    @Value("${application.data.batch-size}")
    private int batchSize;

    @Value("${application.data.notification-multiplier}")
    private int notificationMultiplier;

    public void processEvent(String[] typeFileNameDataCountFromKey){
        try {
            if(typeFileNameDataCountFromKey[0].equals("START"))
            {
                eventProducer.sendMessage(EventNotification.newBuilder()
                            .setFileName(typeFileNameDataCountFromKey[1]).setEventName(EvenetName.DATA_SINK_STARTED.getName())
                            .setEventTimeStamp(Instant.now())
                            .build()
                    );
            }
            else if(typeFileNameDataCountFromKey[0].equals("END")){
                eventProducer.sendMessage(EventNotification.newBuilder()
                        .setFileName(typeFileNameDataCountFromKey[1]).setEventName(EvenetName.DATA_SINK_SUCCESSFUL.getName())
                        .setEventTimeStamp(Instant.now())
                        .build());
            }
            else{
                if (Integer.parseInt(typeFileNameDataCountFromKey[2]) % (batchSize*notificationMultiplier) == 0) {
                    eventProducer.sendMessage(EventNotification.newBuilder()
                            .setFileName(typeFileNameDataCountFromKey[1]).setEventName(EvenetName.DATA_SINK_IN_PROGRESS.getName())
                            .setDetails("No. of Messages Processed Till Now: " + typeFileNameDataCountFromKey[2])
                            .setEventTimeStamp(Instant.now())
                            .build()
                    );
                }
            }
        }
        catch(IOException e){
            logger.error("Error while sending Event {} for file {} event {}",typeFileNameDataCountFromKey[0], typeFileNameDataCountFromKey[1],e );
        }
    }

}
