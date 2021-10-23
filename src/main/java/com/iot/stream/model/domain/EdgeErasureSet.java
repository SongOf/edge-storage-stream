package com.iot.stream.model.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author SongOf
 * @ClassName EdgeErasureSet
 * @Description
 * @Date 2021/10/18 19:57
 * @Version 1.0
 */
@Data
@Table(name = "edge_erasure_set")
public class EdgeErasureSet implements Serializable {
    private static final long serialVersionUID = -6373288806745875777L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "access_key")
    private String accessKey;

    @Column(name = "secret_key")
    private String secretKey;

    @Column(name = "state")
    private String state;

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
