package com.iot.stream.dao.tdengine;

import com.iot.stream.model.domain.EdgeCameraMeta;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TdEdgeCameraMapper {
    void dropDB();

    void createDB();

    void createSuperTable();

    void createTable(EdgeCameraMeta edgeCameraMeta);

    void insertData(EdgeCameraMeta edgeCameraMeta);

    List<EdgeCameraMeta> simpleSelect(@Param("cameraId") String cameraId, @Param("limit") Long limit, @Param("offset") Long offset);
}
