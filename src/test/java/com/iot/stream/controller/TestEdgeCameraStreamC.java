package com.iot.stream.controller;

import com.iot.stream.AbstractTest;
import com.iot.stream.model.dto.SampleQueryDto;
import com.iot.stream.utils.JacksonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * @author SongOf
 * @ClassName TestEdgeCameraStreamC
 * @Description
 * @Date 2021/10/22 22:50
 * @Version 1.0
 */
public class TestEdgeCameraStreamC extends AbstractTest {
    @Autowired
    private EdgeCameraStreamController edgeCameraStreamController;

    @Test
    public void TestSampleQuery() {
        SampleQueryDto sampleQueryDto = new SampleQueryDto();
        sampleQueryDto.setCameraId(3L);
        sampleQueryDto.setLimit(10L);
        sampleQueryDto.setOffset(0L);
        try {
            System.out.println(JacksonUtil.toJson(edgeCameraStreamController.sampleQuery(sampleQueryDto)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
