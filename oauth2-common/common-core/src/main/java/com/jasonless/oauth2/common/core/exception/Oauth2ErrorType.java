package com.jasonless.oauth2.common.core.exception;

import lombok.Getter;

/**
 * @author LiuShiZeng
 */
@Getter
public enum Oauth2ErrorType implements IErrorType{

    MISSING_PARAMETER("400001","缺少参数"),
    PARAMETER_ERROR("400002","参数不正确"),
    CLIENT_SECRET_ERROR("400003","缺少client_secret"),
    GRANT_TYPE_ERROR("400004","grant_type不正确");

    /**
     * 错误类型码
     */
    private String code;
    /**
     * 错误类型描述信息
     */
    private String msg;

    Oauth2ErrorType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
