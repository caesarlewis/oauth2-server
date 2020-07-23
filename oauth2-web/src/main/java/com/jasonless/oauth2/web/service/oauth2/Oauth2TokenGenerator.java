package com.jasonless.oauth2.web.service.oauth2;

import com.jasonless.oauth2.api.entity.dto.OauthClientDetailDTO;
import com.jasonless.oauth2.web.entity.dto.TokenRequest;
import com.jasonless.oauth2.web.entity.vo.OAuth2AccessToken;

import java.util.Map;

/**
 * @author LiuShiZeng
 */
public interface Oauth2TokenGenerator {

    OAuth2AccessToken generatorToken(String grantType, TokenRequest tokenRequest, OauthClientDetailDTO oauthClientDetail);

}
