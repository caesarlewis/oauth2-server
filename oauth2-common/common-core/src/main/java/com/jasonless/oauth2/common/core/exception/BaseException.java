package com.jasonless.oauth2.common.core.exception;

import lombok.Getter;

/**
 * @author LiuShiZeng
 */
@Getter
public class BaseException extends RuntimeException{

    /**
     * 异常对应的错误类型
     */
    private final IErrorType errorType;

    /**
     * 默认是系统异常
     */
    public BaseException() {
        this.errorType = SystemErrorType.SYSTEM_ERROR;
    }

    public BaseException(IErrorType errorType) {
        this.errorType = errorType;
    }

    public BaseException(IErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public BaseException(IErrorType errorType, String message, Throwable cause) {
        super(message, cause);
        this.errorType = errorType;
    }

}
