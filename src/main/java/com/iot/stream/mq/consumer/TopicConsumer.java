package com.iot.stream.mq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TopicConsumer {

    public void handlerSendMqMsg(String body, String topicName, String tags, String keys){
        log.info("handlerSendMqMsg:body={},topicName={},tags={},keys={}",body,topicName,tags,keys);
    }
}
