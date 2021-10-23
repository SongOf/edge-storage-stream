package com.iot.stream.exception;

/**
 * @author SongOf
 * @ClassName BusinessException
 * @Description
 * @Date 2021/10/19 18:32
 * @Version 1.0
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 261333882981071772L;

    protected final String message;

    public BusinessException(String message) {
        this.message = message;
    }

    public BusinessException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
