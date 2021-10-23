package com.iot.stream.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author SongOf
 * @ClassName EdgeCameraMeta
 * @Description
 * @Date 2021/10/22 22:06
 * @Version 1.0
 */
@Data
public class EdgeCameraMetaDto implements Serializable {
    private static final long serialVersionUID = 1180818807228279858L;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Timestamp ts;
    private String objectName;
}
