package com.iot.stream.service;

import com.iot.stream.dao.mysql.EdgeCameraStreamMapper;
import com.iot.stream.dao.tdengine.TdEdgeCameraMapper;
import com.iot.stream.model.context.Context;
import com.iot.stream.model.domain.EdgeCameraMeta;
import com.iot.stream.model.domain.EdgeCameraStream;
import com.iot.stream.model.dto.EdgeCameraMetaDto;
import com.iot.stream.model.dto.SampleQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SongOf
 * @ClassName EdgeCameraStreamService
 * @Description 主要职能是创建流、停止流、查询流 上层是mq
 * @Date 2021/10/18 23:51
 * @Version 1.0
 */
@Service
public class EdgeCameraStreamService {

    @Autowired
    private EdgeErasureSetService edgeErasureSetService;

    @Autowired
    private EdgeCameraService edgeCameraService;

    @Autowired
    private EdgeCameraStreamMapper edgeCameraStreamMapper;

    @Autowired
    private TdEdgeCameraMapper tdEdgeCameraMapper;

    public void createStream(Context context) {
        //加载设备详细信息
        edgeCameraService.loadEdgeCameraInfo(context);
        //选取合适的纠删组
        edgeErasureSetService.pickAvailableEdgeSet(context);
        //创建流
        EdgeCameraStream edgeCameraStream = new EdgeCameraStream();
        edgeCameraStream.setStreamName(context.getEdgeCameraStreamDto().getStreamName() + "-" + new Date().getTime());
        edgeCameraStream.setCameraId(context.getEdgeCameraDto().getCameraId());
        edgeCameraStream.setErasureSetId(context.getEdgeErasureSetDto().getSetId());
        edgeCameraStream.setStartTime(new Date());
        edgeCameraStream.setCreateBy("安安");
        edgeCameraStream.setCreatorId(1L);
        edgeCameraStream.setCreateTime(new Date());
        edgeCameraStream.setUpdateBy("安安");
        edgeCameraStream.setLastOperatorId(1L);
        edgeCameraStream.setUpdateTime(new Date());
        edgeCameraStreamMapper.saveEdgeCameraStream(edgeCameraStream);
        context.getEdgeCameraStreamDto().setStreamId(edgeCameraStream.getId());
        //创建流对应的时序表(元数据)
        EdgeCameraMeta edgeCameraMeta = new EdgeCameraMeta();
        edgeCameraMeta.setCameraId("camera" + context.getEdgeCameraDto().getCameraId());
        edgeCameraMeta.setStreamId(context.getEdgeCameraStreamDto().getStreamId());
        edgeCameraMeta.setErasureSetId(context.getEdgeErasureSetDto().getSetId());
        tdEdgeCameraMapper.createTable(edgeCameraMeta);
        //添加拉流任务

    }

    public void stopStream(Long streamId) {
        //停止相应的任务
    }

    //比较复杂
    public void selectStream() {

    }

    public List<EdgeCameraMetaDto> sampleSelectStream(SampleQueryDto sampleQueryDto) {
        List<EdgeCameraMeta> edgeCameraMetaList = tdEdgeCameraMapper.simpleSelect("camera" + sampleQueryDto.getCameraId(), sampleQueryDto.getLimit(), sampleQueryDto.getOffset());
        return edgeCameraMetaList.stream().map(edgeCameraMeta -> {
            EdgeCameraMetaDto edgeCameraMetaDto = new EdgeCameraMetaDto();
            edgeCameraMetaDto.setTs(edgeCameraMeta.getTs());
            edgeCameraMetaDto.setObjectName(edgeCameraMeta.getObjectName());
            return edgeCameraMetaDto;
        }).collect(Collectors.toList());
    }
}
