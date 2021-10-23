package com.iot.stream.controller;

import com.iot.stream.model.domain.R;
import com.iot.stream.model.dto.SampleQueryDto;
import com.iot.stream.service.EdgeCameraStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SongOf
 * @ClassName EdgeCameraStreamController
 * @Description
 * @Date 2021/10/22 22:22
 * @Version 1.0
 */
@RestController
@RequestMapping("stream")
public class EdgeCameraStreamController extends BaseController {
    @Autowired
    private EdgeCameraStreamService edgeCameraStreamService;

    @GetMapping("sampleQuery")
    public R sampleQuery(SampleQueryDto sampleQueryDto) {
        return result(edgeCameraStreamService.sampleSelectStream(sampleQueryDto));
    }
}
