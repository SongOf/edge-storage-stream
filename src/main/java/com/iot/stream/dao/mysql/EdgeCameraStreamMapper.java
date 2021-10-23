package com.iot.stream.dao.mysql;

import com.iot.stream.model.domain.EdgeCameraStream;

import java.util.List;

/**
 * @author SongOf
 * @InterfaceName EdgeCameraStreamMapper
 * @Description
 * @Date 2021/10/18 20:08
 * @Version 1.0
 */
public interface EdgeCameraStreamMapper {

    public int saveEdgeCameraStream(EdgeCameraStream edgeCameraStream);

    public int deleteEdgeCameraStreamByIds(List<Long> ids);

    public int updateEdgeCameraStream(EdgeCameraStream edgeCameraStream);

    public List<EdgeCameraStream> selectEdgeCameraStreamList(EdgeCameraStream edgeCameraStream);
}
