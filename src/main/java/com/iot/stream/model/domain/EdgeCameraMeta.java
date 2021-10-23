package com.iot.stream.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class EdgeCameraMeta implements Serializable {
    private static final long serialVersionUID = -8810510706864728954L;

    private String cameraId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Timestamp ts;
    private String objectName;
    private Long streamId;
    private Long erasureSetId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Timestamp start;


}
