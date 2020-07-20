package com.jasonless.oauth2.api.entity.dto;

import lombok.Data;

/**
 * @author LiuShiZeng
 */
@Data
public class OauthClientDetailDTO {

    private String clientId;

    private String secretKey;

    private String clientName;

    private String authorizedGrantType;

    private String redirectUri;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String autoApprove;

}
