package com.iot.stream.model.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author SongOf
 * @ClassName EdgeSetNode
 * @Description
 * @Date 2021/10/18 21:56
 * @Version 1.0
 */
@Data
@Table(name = "edge_set_node")
public class EdgeSetNode implements Serializable {
    private static final long serialVersionUID = 3263798227808171732L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "set_id")
    private Long setId;

    @Column(name = "node_id")
    private Long nodeId;

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
