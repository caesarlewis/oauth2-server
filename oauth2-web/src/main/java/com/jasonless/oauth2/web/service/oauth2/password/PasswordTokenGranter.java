package com.jasonless.oauth2.web.service.oauth2.password;

import com.jasonless.oauth2.api.entity.domain.Oauth2GrantType;
import com.jasonless.oauth2.api.entity.dto.OauthClientDetailDTO;
import com.jasonless.oauth2.common.core.exception.Oauth2ErrorType;
import com.jasonless.oauth2.common.web.util.JwtTokenUtil;
import com.jasonless.oauth2.web.entity.dto.TokenRequest;
import com.jasonless.oauth2.web.entity.vo.OAuth2AccessToken;
import com.jasonless.oauth2.web.exception.Oauth2Exception;
import com.jasonless.oauth2.web.service.oauth2.AbstractOauth2TokenGranter;
import com.jasonless.oauth2.web.util.OAuth2Util;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuShiZeng
 */
public class PasswordTokenGranter extends AbstractOauth2TokenGranter {

    protected PasswordTokenGranter() {
        super(Oauth2GrantType.PASSWORD.getValue());
    }

    @Override
    protected OAuth2AccessToken getAccessToken(TokenRequest tokenRequest) {



        Map<String,Object> accessMap = new HashMap<>();
        accessMap.put(OAuth2Util.CLIENT_ID,tokenRequest.getOauthClientDetailDTO().getClientId());

        //   Long expiresIn = DateTime.now().plusDays(1).toDate().getTime()/1000;
        Long expiresIn = DateTime.now().plusHours(tokenRequest.getOauthClientDetailDTO().getAccessTokenValidity()).toDate().getTime()/1000;
        accessMap.put("exp", expiresIn);
        accessMap.put(OAuth2Util.USERNAME,tokenRequest.getRequestParameters().get(OAuth2Util.USERNAME));
        String accessToken = JwtTokenUtil.generatorToken(accessMap);

        Map<String,Object> reAccessMap = new HashMap<>();
        reAccessMap.put(OAuth2Util.CLIENT_ID,tokenRequest.getOauthClientDetailDTO().getClientId());
        reAccessMap.put(OAuth2Util.USERNAME,tokenRequest.getRequestParameters().get(OAuth2Util.USERNAME));
        String refreshToken = JwtTokenUtil.generatorToken(reAccessMap);


        OAuth2AccessToken oAuth2AccessToken = new OAuth2AccessToken();
        oAuth2AccessToken.setAccess_token(accessToken);
        oAuth2AccessToken.setExpires_in(expiresIn);
        oAuth2AccessToken.setRefresh_token(refreshToken);

        return oAuth2AccessToken;
    }

    @Override
    protected void verifyInfo(TokenRequest tokenRequest) {
        super.verifyInfo(tokenRequest);

        String username = tokenRequest.getRequestParameters().get(OAuth2Util.USERNAME);
        String password = tokenRequest.getRequestParameters().get(OAuth2Util.PASSWORD);
        if(username==null){
            throw new Oauth2Exception(Oauth2ErrorType.MISSING_PARAMETER,"缺少username");
        }
        if(password==null){
            throw new Oauth2Exception(Oauth2ErrorType.MISSING_PARAMETER,"缺少password");
        }



    }
}
