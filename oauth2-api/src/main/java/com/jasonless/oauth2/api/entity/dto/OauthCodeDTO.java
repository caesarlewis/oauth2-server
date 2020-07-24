package com.jasonless.oauth2.api.entity.dto;

import lombok.Data;

/**
 * @author LiuShiZeng
 */
@Data
public class OauthCodeDTO  {

    private String code;

    private String clientId;

    private String userId;

}
