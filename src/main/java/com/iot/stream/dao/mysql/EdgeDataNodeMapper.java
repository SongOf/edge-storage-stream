package com.iot.stream.dao.mysql;

import com.iot.stream.model.domain.EdgeDataNode;
import java.util.List;

/**
 * @author SongOf
 * @InterfaceName EdgeDataNodeMapper
 * @Description
 * @Date 2021/10/18 20:09
 * @Version 1.0
 */
public interface EdgeDataNodeMapper {

    public int saveEdgeDataNode(EdgeDataNode edgeDataNode);

    public int deleteEdgeDataNodeByIds(List<Long> ids);

    public int updateEdgeDataNode(EdgeDataNode edgeDataNode);

    public List<EdgeDataNode> selectEdgeDataNodeList(EdgeDataNode edgeDataNode);
}
