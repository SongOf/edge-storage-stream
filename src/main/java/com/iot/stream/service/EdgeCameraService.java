package com.iot.stream.service;

import com.iot.stream.constant.ExceptionMsg;
import com.iot.stream.dao.mysql.EdgeCameraMapper;
import com.iot.stream.exception.BusinessException;
import com.iot.stream.model.context.Context;
import com.iot.stream.model.domain.EdgeCamera;
import com.iot.stream.model.dto.EdgeCameraDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SongOf
 * @ClassName EdgeCameraService
 * @Description
 * @Date 2021/10/19 19:44
 * @Version 1.0
 */
@Service
public class EdgeCameraService {
    @Autowired
    private EdgeCameraMapper edgeCameraMapper;

    //todo:线程池优化
    public void loadEdgeCameraInfo(Context context) {
        EdgeCameraDto tarEdgeCameraDto = context.getEdgeCameraDto();
        if(tarEdgeCameraDto == null || tarEdgeCameraDto.getCameraId() == null) {
            throw new BusinessException(ExceptionMsg.NO_FIELD_FOR_CONTEXT);
        }
        EdgeCamera detailCamera = edgeCameraMapper.selectEdgeCameraById(context.getEdgeCameraDto().getCameraId());
        if(detailCamera == null) {
            throw new BusinessException(ExceptionMsg.NO_EDGE_CAMERA);
        }
        context.getEdgeCameraDto().setMapperId(detailCamera.getMapperId());
        context.getEdgeCameraDto().setSerialNumber(detailCamera.getSerialNumber());
        context.getEdgeCameraDto().setValidateCode(detailCamera.getValidateCode());
        context.getEdgeCameraDto().setIp(detailCamera.getIp());
        context.getEdgeCameraDto().setProtocol(detailCamera.getProtocol());
        context.getEdgeCameraDto().setUrl(detailCamera.getUrl());
        context.getEdgeCameraDto().setState(detailCamera.getState());
    }
}
