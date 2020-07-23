package com.jasonless.oauth2.web.entity.dto;

import com.jasonless.oauth2.api.entity.dto.OauthClientDetailDTO;
import lombok.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuShiZeng
 */
@Data
public class TokenRequest {

    private String clientId;

    private String grantType;

    private String username;

    private String scope;

    private Map<String, String> requestParameters = Collections
            .unmodifiableMap(new HashMap<String, String>());

    private OauthClientDetailDTO oauthClientDetailDTO;

    public TokenRequest(String clientId,String grantType, Map<String, String> requestParameters){
        this.clientId = clientId;
        this.grantType = grantType;
        this.requestParameters = requestParameters;
    }


}
