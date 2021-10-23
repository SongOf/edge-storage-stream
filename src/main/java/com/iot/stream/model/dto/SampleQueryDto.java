package com.iot.stream.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author SongOf
 * @ClassName SelectReqStream
 * @Description
 * @Date 2021/10/22 22:12
 * @Version 1.0
 */
@Data
public class SampleQueryDto implements Serializable {
    private static final long serialVersionUID = -5837253161496871994L;

    private Long cameraId;
    private Long limit;
    private Long offset;
}
