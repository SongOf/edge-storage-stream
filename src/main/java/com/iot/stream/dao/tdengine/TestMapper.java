package com.iot.stream.dao.tdengine;

import com.iot.stream.model.domain.Weather;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//Weather test
public interface TestMapper {
    Map<String, Object> lastOne();

    void dropDB();

    void createDB();

    void createSuperTable();

    void createTable(Weather weather);

    List<Weather> select(@Param("limit") Long limit, @Param("offset") Long offset);

    int insert(Weather weather);

    int count();

    List<String> getSubTables();

    List<Weather> avg();
}
