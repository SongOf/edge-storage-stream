package com.iot.stream.dao.mysql;

import com.iot.stream.model.domain.EdgeCamera;

import java.util.List;

public interface EdgeCameraMapper {

    public EdgeCamera selectEdgeCameraById(Long id);

    public List<EdgeCamera> selectAll();
}
