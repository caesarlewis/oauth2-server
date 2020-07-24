package com.jasonless.oauth2.web.domain;

import lombok.Getter;

/**
 * @author LiuShiZeng
 */
@Getter
public enum Oauth2GrantTypeClass {

    PASSWORD("password","net.okair.oauth2.web.service.password.Oauth2PasswordTokenGranterService"),
    IMPLICIT("implicit",""),
    CLIENT_CREDENTIALS("client_credentials","net.okair.oauth2.web.service.client.Oauth2ClientCredentialsTokenGranterService"),
    AUTHORIZATION_CODE("authorization_code","net.okair.oauth2.web.service.code.Oauth2AuthorizationCodeTokenGranterService");

    private String name;

    private String value;

    Oauth2GrantTypeClass(String name, String value){
        this.name= name;
        this.value= value;
    }

}
