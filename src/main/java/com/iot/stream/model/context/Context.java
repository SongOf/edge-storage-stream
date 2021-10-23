package com.iot.stream.model.context;

import com.iot.stream.model.dto.EdgeCameraDto;
import com.iot.stream.model.dto.EdgeCameraStreamDto;
import com.iot.stream.model.dto.EdgeErasureSetDto;
import lombok.Data;

import java.io.Serializable;

/**
 * @author SongOf
 * @ClassName Context
 * @Description
 * @Date 2021/10/19 18:09
 * @Version 1.0
 */
@Data
public class Context implements Serializable {
    private static final long serialVersionUID = 4438549021930154440L;

    private EdgeCameraDto edgeCameraDto;
    private EdgeErasureSetDto edgeErasureSetDto;
    private EdgeCameraStreamDto edgeCameraStreamDto;
}
