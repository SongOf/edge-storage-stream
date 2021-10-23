package com.iot.stream.mapper.mysql;

import com.iot.stream.AbstractTest;
import com.iot.stream.constant.EdgeErasureSetState;
import com.iot.stream.dao.mysql.EdgeDataNodeMapper;
import com.iot.stream.dao.mysql.EdgeErasureSetMapper;
import com.iot.stream.dao.mysql.EdgeSetNodeMapper;
import com.iot.stream.model.domain.EdgeDataNode;
import com.iot.stream.model.domain.EdgeErasureSet;
import com.iot.stream.model.domain.EdgeSetNode;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author SongOf
 * @ClassName TestEdgeDataNode
 * @Description
 * @Date 2021/10/18 21:28
 * @Version 1.0
 */
public class TestEdgeSet extends AbstractTest {
    @Autowired
    private EdgeDataNodeMapper edgeDataNodeMapper;

    @Autowired
    private EdgeErasureSetMapper edgeErasureSetMapper;

    @Autowired
    private EdgeSetNodeMapper edgeSetNodeMapper;

    @Test
    public void TestSaveSet() {
        EdgeErasureSet edgeErasureSet = new EdgeErasureSet();
        edgeErasureSet.setName("edge-storage-set-01");
        edgeErasureSet.setAccessKey("admin");
        edgeErasureSet.setSecretKey("admin123");
        edgeErasureSet.setState(EdgeErasureSetState.AVAILABLE); //常量集
        edgeErasureSet.setCreateBy("安安");
        edgeErasureSet.setCreatorId(1L);
        edgeErasureSet.setCreateTime(new Date());
        edgeErasureSet.setUpdateBy("安安");
        edgeErasureSet.setLastOperatorId(1L);
        edgeErasureSet.setUpdateTime(new Date());
        edgeErasureSetMapper.saveEdgeErasureSet(edgeErasureSet);
        Long set = edgeErasureSet.getId();
        //插入关系

        Long node1 = TestSaveNode1();
        Long node2 = TestSaveNode2();
        Long node3 = TestSaveNode3();
        Long node4 = TestSaveNode4();

        TestSaveSetNode(set, node1);
        TestSaveSetNode(set, node2);
        TestSaveSetNode(set, node3);
        TestSaveSetNode(set, node4);
    }

    public Long TestSaveNode1() {
        EdgeDataNode edgeDataNode = new EdgeDataNode();
        edgeDataNode.setName("edge-nodes");
        edgeDataNode.setNodeIp("192.168.1.101");
        edgeDataNode.setNodePort("9000");
        edgeDataNode.setVolume("/export1");
        edgeDataNode.setCreateBy("安安");
        edgeDataNode.setCreatorId(1L);
        edgeDataNode.setCreateTime(new Date());
        edgeDataNode.setUpdateBy("安安");
        edgeDataNode.setLastOperatorId(1L);
        edgeDataNode.setUpdateTime(new Date());
        edgeDataNodeMapper.saveEdgeDataNode(edgeDataNode);
        return edgeDataNode.getId();
    }

    public Long TestSaveNode2() {
        EdgeDataNode edgeDataNode = new EdgeDataNode();
        edgeDataNode.setName("edge-nodes");
        edgeDataNode.setNodeIp("192.168.1.102");
        edgeDataNode.setNodePort("9000");
        edgeDataNode.setVolume("/export1");
        edgeDataNode.setCreateBy("安安");
        edgeDataNode.setCreatorId(1L);
        edgeDataNode.setCreateTime(new Date());
        edgeDataNode.setUpdateBy("安安");
        edgeDataNode.setLastOperatorId(1L);
        edgeDataNode.setUpdateTime(new Date());
        edgeDataNodeMapper.saveEdgeDataNode(edgeDataNode);
        return edgeDataNode.getId();
    }

    public Long TestSaveNode3() {
        EdgeDataNode edgeDataNode = new EdgeDataNode();
        edgeDataNode.setName("edge-nodes");
        edgeDataNode.setNodeIp("192.168.1.103");
        edgeDataNode.setNodePort("9000");
        edgeDataNode.setVolume("/export1");
        edgeDataNode.setCreateBy("安安");
        edgeDataNode.setCreatorId(1L);
        edgeDataNode.setCreateTime(new Date());
        edgeDataNode.setUpdateBy("安安");
        edgeDataNode.setLastOperatorId(1L);
        edgeDataNode.setUpdateTime(new Date());
        edgeDataNodeMapper.saveEdgeDataNode(edgeDataNode);
        return edgeDataNode.getId();
    }

    public Long TestSaveNode4() {
        EdgeDataNode edgeDataNode = new EdgeDataNode();
        edgeDataNode.setName("edge-nodes");
        edgeDataNode.setNodeIp("192.168.1.104");
        edgeDataNode.setNodePort("9000");
        edgeDataNode.setVolume("/export1");
        edgeDataNode.setCreateBy("安安");
        edgeDataNode.setCreatorId(1L);
        edgeDataNode.setCreateTime(new Date());
        edgeDataNode.setUpdateBy("安安");
        edgeDataNode.setLastOperatorId(1L);
        edgeDataNode.setUpdateTime(new Date());
        edgeDataNodeMapper.saveEdgeDataNode(edgeDataNode);
        return edgeDataNode.getId();
    }

    public void TestSaveSetNode(Long setId, Long nodeId) {
        EdgeSetNode edgeSetNode = new EdgeSetNode();
        edgeSetNode.setSetId(setId);
        edgeSetNode.setNodeId(nodeId);
        edgeSetNode.setCreateBy("安安");
        edgeSetNode.setCreatorId(1L);
        edgeSetNode.setCreateTime(new Date());
        edgeSetNode.setUpdateBy("安安");
        edgeSetNode.setLastOperatorId(1L);
        edgeSetNode.setUpdateTime(new Date());
        edgeSetNodeMapper.saveEdgeSetNode(edgeSetNode);
    }
}
