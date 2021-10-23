package com.iot.stream.dao.mysql;

import com.iot.stream.model.domain.EdgeErasureSet;
import com.iot.stream.model.domain.EdgeSetNode;

import java.util.List;

/**
 * @author SongOf
 * @ClassName EdgeSetNodeMapper
 * @Description
 * @Date 2021/10/18 21:59
 * @Version 1.0
 */
public interface EdgeSetNodeMapper {
    public int saveEdgeSetNode(EdgeSetNode edgeSetNode);

    public int deleteEdgeSetNodeByIds(List<Long> ids);

    public int updateEdgeSetNodeSet(EdgeSetNode edgeSetNode);

    public List<EdgeErasureSet> selectEdgeSetNodeList(EdgeSetNode edgeSetNode);
}
