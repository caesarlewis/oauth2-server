package com.jasonless.oauth2.api.entity.domain;

import lombok.Getter;

/**
 * @author LiuShiZeng
 */
@Getter
public enum Oauth2GrantType {

    PASSWORD("密码模式","password"),
    CLIENT_CREDENTIALS("客户端模式","client_credentials"),
    AUTHORIZATION_CODE("授权码模式","authorization_code"),
    IMPLICIT("隐藏式","implicit");

    private final String name;

    private final String value;

    Oauth2GrantType(String name,String value){
        this.name= name;
        this.value= value;
    }

}
