package com.iot.stream.model.dto;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @author SongOf
 * @ClassName EdgeCameraDto
 * @Description
 * @Date 2021/10/19 18:11
 * @Version 1.0
 */
@Data
public class EdgeCameraDto implements Serializable {
    private static final long serialVersionUID = -882645469087894903L;

    private Long cameraId;
    private Long mapperId;
    private Long serialNumber;
    private String validateCode;
    private String ip;
    private String protocol;
    private String url;
    private String state;
}
