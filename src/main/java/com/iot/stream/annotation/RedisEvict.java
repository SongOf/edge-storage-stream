package com.iot.stream.annotation;

import java.lang.annotation.*;

/**
 * @author SongOf
 * @AnnotationName RedisEvict
 * @Description
 * @Date 2021/10/19 11:44
 * @Version 1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisEvict {
    String key();

    String fieldKey();
}
