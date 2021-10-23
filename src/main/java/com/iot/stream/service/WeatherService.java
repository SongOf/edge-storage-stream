package com.iot.stream.service;

import com.iot.stream.dao.tdengine.TestMapper;
import com.iot.stream.model.domain.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class WeatherService {

    @Autowired
    private TestMapper testMapper;
    private Random random = new Random(System.currentTimeMillis());
    private String[] locations = {"北京", "上海", "广州", "深圳", "天津"};

    public int init() {
        testMapper.dropDB();
        testMapper.createDB();
        testMapper.createSuperTable();
        long ts = System.currentTimeMillis();
        long thirtySec = 1000 * 30;
        int count = 0;
        for (int i = 0; i < 20; i++) {
            Weather weather = new Weather(new Timestamp(ts + (thirtySec * i)), 30 * random.nextFloat(), random.nextInt(100));
            weather.setLocation(locations[random.nextInt(locations.length)]);
            weather.setGroupId(i % locations.length);
            weather.setNote("note-" + i);
            testMapper.createTable(weather);
            count += testMapper.insert(weather);
        }
        return count;
    }

    public List<Weather> query(Long limit, Long offset) {
        return testMapper.select(limit, offset);
    }

    public int save(float temperature, float humidity) {
        Weather weather = new Weather();
        weather.setTemperature(temperature);
        weather.setHumidity(humidity);

        return testMapper.insert(weather);
    }

    public int count() {
        return testMapper.count();
    }

    public List<String> getSubTables() {
        return testMapper.getSubTables();
    }

    public List<Weather> avg() {
        return testMapper.avg();
    }

    public Weather lastOne() {
        Map<String, Object> result = testMapper.lastOne();

        long ts = (long) result.get("ts");
        float temperature = (float) result.get("temperature");
        float humidity = (float) result.get("humidity");
        String note = (String) result.get("note");
        int groupId = (int) result.get("groupid");
        String location = (String) result.get("location");

        Weather weather = new Weather(new Timestamp(ts), temperature, humidity);
        weather.setNote(note);
        weather.setGroupId(groupId);
        weather.setLocation(location);
        return weather;
    }
}
