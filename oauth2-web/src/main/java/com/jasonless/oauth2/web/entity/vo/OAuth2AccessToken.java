package com.jasonless.oauth2.web.entity.vo;

import lombok.Data;

/**
 * @author LiuShiZeng
 */
@Data
public class OAuth2AccessToken {

    private String access_token;

    private String token_type = "Bearer";

    private String refresh_token;

    private Long expires_in;

}
