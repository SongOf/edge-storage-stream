package com.iot.stream.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author SongOf
 * @ClassName EdgeCameraStreamDto
 * @Description
 * @Date 2021/10/19 20:27
 * @Version 1.0
 */
@Data
public class EdgeCameraStreamDto implements Serializable {
    private Long streamId;
    private String streamName;
}
