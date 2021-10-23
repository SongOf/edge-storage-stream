package com.iot.stream.mapper.mysql;

import com.iot.stream.AbstractTest;
import com.iot.stream.dao.mysql.EdgeCameraMapper;
import com.iot.stream.utils.JacksonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class TestEdgeCamera extends AbstractTest {
    @Autowired
    private EdgeCameraMapper edgeCameraMapper;

    @Test
    public void TestGetAll() {
        try {
            System.out.println(JacksonUtil.toJson(edgeCameraMapper.selectAll()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
