package com.iot.stream.model.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author SongOf
 * @ClassName EdgeDataNode
 * @Description
 * @Date 2021/10/18 20:03
 * @Version 1.0
 */
@Data
@Table(name = "edge_data_node")
public class EdgeDataNode implements Serializable {
    private static final long serialVersionUID = 943369466026693374L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "node_ip")
    private String nodeIp;

    @Column(name = "node_port")
    private String nodePort;

    @Column(name = "volume")
    private String volume;

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
