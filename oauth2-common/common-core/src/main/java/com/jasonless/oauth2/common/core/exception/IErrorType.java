package com.jasonless.oauth2.common.core.exception;

/**
 * @author LiuShiZeng
 */
public interface IErrorType {

    /**
     * 返回code
     *
     * @return
     */
    String getCode();

    /**
     * 返回msg
     *
     * @return
     */
    String getMsg();

}
