package at.fhtw.swen3.notification.consumer;

import at.fhtw.swen3.model.PushNotif;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class KafkaConsumer {


    @Autowired
    FirebaseMessaging firebaseMessaging;


    @KafkaListener(topics = "hopChange", groupId = "hop")
    public void listenGroupFoo(PushNotif notif) {

        Message msg = Message.builder()
                .setToken("flHvEBKsTk6Nodd0U7eQ9g:APA91bHsAkbGg2mxXBYR55huYuTxYkGlAG_afEFgDfeEKBXL6uyySki0si3mnCG0HcB67ooNyjb-VBB13dkHasFgZmLdmQ0Zusxk5kHqDESI2lVDUZN6u2ggGKdq85605Xn61azuD-Op")
                .putData("body", String.valueOf(notif))
                .setNotification(Notification.builder().setTitle("Update on parcel with ID: "+notif.getCode()).setBody("Arrived on Hop: "+notif.getHopArrival()).build())
                .build();

        try {
            if(!notif.getHopArrival().equals("")) {
                String id = firebaseMessaging.send(msg);
                log.info(id);
            }
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
        System.out.println("Received Message in group foo: " + notif);
    }
}