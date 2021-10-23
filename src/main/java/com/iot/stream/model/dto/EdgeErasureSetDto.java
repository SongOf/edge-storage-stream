package com.iot.stream.model.dto;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @author SongOf
 * @ClassName EdgeErasureSetDto
 * @Description
 * @Date 2021/10/19 18:14
 * @Version 1.0
 */
@Data
public class EdgeErasureSetDto implements Serializable {
    private static final long serialVersionUID = 4129803623419664066L;

    private Long setId;
    private String setName;
    private Double setScore;
    private String accessKey;
    private String secretKey;
    private String state;
}
