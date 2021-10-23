package com.iot.stream.model.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author SongOf
 * @ClassName EdgeCameraStream
 * @Description
 * @Date 2021/10/18 19:49
 * @Version 1.0
 */
@Data
@Table(name = "edge_camera_stream")
public class EdgeCameraStream implements Serializable {
    private static final long serialVersionUID = 459178983322002250L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "stream_name")
    private String streamName;

    @Column(name = "camera_id")
    private Long cameraId;

    @Column(name = "erasure_set_id")
    private Long erasureSetId;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "last_operator_id")
    private Long lastOperatorId;

    @Column(name = "update_time")
    private Date updateTime;
}
