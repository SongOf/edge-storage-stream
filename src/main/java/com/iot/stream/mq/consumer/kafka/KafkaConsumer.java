package com.iot.stream.mq.consumer.kafka;

import com.iot.stream.dao.tdengine.TdEdgeCameraMapper;
import com.iot.stream.model.domain.EdgeCameraMeta;
import com.iot.stream.model.message.KafkaMessage;
import io.minio.*;
import io.minio.errors.*;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SongOf
 * @ClassName KafkaConsumer
 * @Description
 * @Date 2021/10/21 20:34
 * @Version 1.0
 */
@Service
public class KafkaConsumer {
    public static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private TdEdgeCameraMapper tdEdgeCameraMapper;

    private MinioClient minioClient;

//    @KafkaListener(topics = "edge_camera_185339746", groupId = "default_consumer_group", containerFactory = "kafkaListenerContainerFactory")
    public void consumeJson(KafkaMessage kafkaMessage) {
        System.out.println("Consumed JSON Message: " + kafkaMessage);
    }

    @PostConstruct
    public void initMinioClient() {
        minioClient = MinioClient.builder()
                .endpoint("http://192.168.1.101:9000/")
                .credentials("admin", "admin123")
                .build();
        boolean found = false;
        try {
            found = minioClient.bucketExists(BucketExistsArgs.builder().bucket("camera" + 3L).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!found) {
            // Make a new bucket called 'asiatrip'.
            try {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket("camera" + 3L).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Bucket 'asiatrip' already exists.");
        }
    }

    @KafkaListener(topics = "edge_camera_185339746")
    public void consume(ConsumerRecord<String, KafkaMessage> record) {
        LOGGER.info("Received message from topic: {}", record.topic());
        KafkaMessage kafkaMessage = record.value();

        EdgeCameraMeta edgeCameraMeta = new EdgeCameraMeta();
        edgeCameraMeta.setTs(new Timestamp(System.currentTimeMillis()));
        edgeCameraMeta.setCameraId("camera" + 3L);
        edgeCameraMeta.setObjectName(record.topic() + edgeCameraMeta.getTs().toString());
        edgeCameraMeta.setStreamId(2L);
        edgeCameraMeta.setErasureSetId(3L);
        tdEdgeCameraMapper.insertData(edgeCameraMeta);

        // Create a InputStream for object upload.
        ByteArrayInputStream bais = new ByteArrayInputStream(kafkaMessage.getPix());
        // Create headers
        Map<String, String> headers = new HashMap<>();
        // Add custom content type
        headers.put("Content-Type", "application/octet-stream");
        // Add storage class
        headers.put("X-Amz-Storage-Class", "REDUCED_REDUNDANCY");

        // Add custom/user metadata
        Map<String, String> userMetadata = new HashMap<>();
        userMetadata.put("camera", record.topic());

        // Create object 'my-objectname' with user metadata and other properties in 'my-bucketname'
        // with content
        // from the input stream.
        try {
            minioClient.putObject(
                    PutObjectArgs.builder().bucket("camera" + 3L).object(record.topic() + edgeCameraMeta.getTs().toString()).stream(
                            bais, bais.available(), -1)
                            .headers(headers)
                            .userMetadata(userMetadata)
                            .build());
            bais.close();
            System.out.println("my-objectname is uploaded successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
