package com.iot.stream.service;

import com.iot.stream.AbstractTest;
import com.iot.stream.model.context.Context;
import com.iot.stream.model.dto.EdgeCameraDto;
import com.iot.stream.model.dto.EdgeCameraStreamDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author SongOf
 * @ClassName service
 * @Description
 * @Date 2021/10/19 14:31
 * @Version 1.0
 */
public class TestEdgeCameraStream extends AbstractTest {
    @Autowired
    private EdgeCameraStreamService edgeCameraStreamService;

    @Test
    public void TestCreateStream() {
        Context context = new Context();
        context.setEdgeCameraDto(new EdgeCameraDto());
        context.getEdgeCameraDto().setCameraId(3L);
        context.setEdgeCameraStreamDto(new EdgeCameraStreamDto());
        context.getEdgeCameraStreamDto().setStreamName("stream");
        edgeCameraStreamService.createStream(context);
    }

    @Test
    public void Test() {
        System.out.println(new Date().getTime());
    }
}
