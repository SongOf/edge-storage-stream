package com.iot.stream.mapper.tdengine;

import com.iot.stream.AbstractTest;
import com.iot.stream.dao.tdengine.TdEdgeCameraMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestTdEdgeCamera extends AbstractTest {

    @Autowired
    private TdEdgeCameraMapper tdEdgeCameraMapper;

    @Test
    public void TestCreateDb() {
        tdEdgeCameraMapper.createDB();
    }

    @Test
    public void TestDropDb() {
        tdEdgeCameraMapper.dropDB();
    }

    @Test
    public void TestCreateSuperTable() {
        tdEdgeCameraMapper.createSuperTable();
    }
}
