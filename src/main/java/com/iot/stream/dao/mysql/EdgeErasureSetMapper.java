package com.iot.stream.dao.mysql;

import com.iot.stream.model.domain.EdgeErasureSet;

import java.util.List;

/**
 * @author SongOf
 * @ClassName EdgeErasureSetMapper
 * @Description
 * @Date 2021/10/18 20:09
 * @Version 1.0
 */
public interface EdgeErasureSetMapper {

    public int saveEdgeErasureSet(EdgeErasureSet edgeErasureSet);

    public int deleteEdgeErasureSetByIds(List<Long> ids);

    public int updateEdgeErasureSet(EdgeErasureSet edgeErasureSet);

    public List<EdgeErasureSet> selectEdgeErasureSetList(EdgeErasureSet edgeErasureSet);
}
