package com.iot.stream.service;

import com.alibaba.fastjson.JSON;
import com.iot.stream.constant.ExceptionMsg;
import com.iot.stream.constant.RedisKey;
import com.iot.stream.dao.mysql.EdgeErasureSetMapper;
import com.iot.stream.exception.BusinessException;
import com.iot.stream.model.context.Context;
import com.iot.stream.model.domain.EdgeErasureSet;
import com.iot.stream.model.dto.EdgeErasureSetDto;
import com.iot.stream.utils.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author SongOf
 * @ClassName EdgeErasureSetService
 * @Description
 * @Date 2021/10/19 18:17
 * @Version 1.0
 */
@Service
public class EdgeErasureSetService {

    @Autowired
    private ZSetOperations<String, Object> zSetOperations;

    @Autowired
    private EdgeErasureSetMapper edgeErasureSetMapper;

    //todo:线程池优化
    public void pickAvailableEdgeSet(Context context) {
        Set<ZSetOperations.TypedTuple<Object>> availableSets = zSetOperations.reverseRangeByScoreWithScores(RedisKey.EDGE_SET_REDIS_KEY, 0, 100);
        if(availableSets.size() <= 0) {
            throw new BusinessException(ExceptionMsg.NO_AVAILABLE_EDGE_SET);
        }
        EdgeErasureSetDto edgeErasureSetDto = new EdgeErasureSetDto();
        for(ZSetOperations.TypedTuple<Object> edgeSet : availableSets) {
            edgeErasureSetDto.setSetName(String.valueOf(edgeSet.getValue()));
            edgeErasureSetDto.setSetScore(edgeSet.getScore());
            Map setNameMap = JSON.parseObject(edgeErasureSetDto.getSetName(), Map.class);
            edgeErasureSetDto.setSetName(String.valueOf(setNameMap.get("job")));
            break;
        }
        EdgeErasureSet edgeErasureSet = new EdgeErasureSet();
        edgeErasureSet.setName(edgeErasureSetDto.getSetName());
        List<EdgeErasureSet> edgeErasureSets = edgeErasureSetMapper.selectEdgeErasureSetList(edgeErasureSet);
        if(edgeErasureSets.size() <= 0) {
            throw new BusinessException(ExceptionMsg.NO_DETAIL_EDGE_SET);
        }
        EdgeErasureSet tarEdgeErasureSet = edgeErasureSets.get(0);
        if(tarEdgeErasureSet.getName().equals(edgeErasureSetDto.getSetName())) {
            edgeErasureSetDto.setSetId(tarEdgeErasureSet.getId());
            edgeErasureSetDto.setAccessKey(tarEdgeErasureSet.getAccessKey());
            edgeErasureSetDto.setSecretKey(tarEdgeErasureSet.getSecretKey());
            edgeErasureSetDto.setState(tarEdgeErasureSet.getState());
        }
        context.setEdgeErasureSetDto(edgeErasureSetDto);
    }
}
