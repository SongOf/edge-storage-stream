package com.iot.stream.model.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "edge_camera")
public class EdgeCamera implements Serializable {
    private static final long serialVersionUID = -7116135943822693807L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "mapper_id")
    private Long mapperId;

    @Column(name = "serial_number")
    private Long serialNumber;

    @Column(name = "validate_code")
    private String validateCode;

    @Column(name = "ip")
    private String ip;

    @Column(name = "protocol")
    private String protocol;

    @Column(name = "url")
    private String url;

    @Column(name = "state")
    private String state;

    @Column(name = "version")
    private Long version;

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
