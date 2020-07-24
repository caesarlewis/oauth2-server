package com.jasonless.oauth2.web.service.oauth2;

import com.jasonless.oauth2.api.entity.dto.OauthClientDetailDTO;
import com.jasonless.oauth2.common.core.exception.Oauth2ErrorType;
import com.jasonless.oauth2.common.web.util.JwtTokenUtil;
import com.jasonless.oauth2.web.entity.dto.TokenRequest;
import com.jasonless.oauth2.web.entity.vo.OAuth2AccessToken;
import com.jasonless.oauth2.web.exception.Oauth2Exception;
import com.jasonless.oauth2.web.util.OAuth2Util;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuShiZeng
 */
public abstract class AbstractOauth2TokenGranter implements Oauth2TokenGenerator {

    private final String grantType;

    protected AbstractOauth2TokenGranter(String grantType) {
        //    this.clientDetailsService = clientDetailsService;
        this.grantType = grantType;
    }

    @Override
    public OAuth2AccessToken generatorToken(String grantType, TokenRequest tokenRequest, OauthClientDetailDTO oauthClientDetail) {
        if (!this.grantType.equals(grantType)) {
            return null;
        }

        String clientId = tokenRequest.getClientId();
        //       OauthClientDetail client = clientDetailsService.getById(clientId);
        //      validateGrantType(grantType, client);
        tokenRequest.setOauthClientDetailDTO(oauthClientDetail);
        verifyInfo(tokenRequest);

        return getAccessToken(tokenRequest);
    }

    protected OAuth2AccessToken getAccessToken(TokenRequest tokenRequest)  {

        Map<String,Object> accessMap = new HashMap<>();
        accessMap.put(OAuth2Util.CLIENT_ID,tokenRequest.getOauthClientDetailDTO().getClientId());

     //   Long expiresIn = DateTime.now().plusDays(1).toDate().getTime()/1000;
        Long expiresIn = DateTime.now().plusHours(tokenRequest.getOauthClientDetailDTO().getAccessTokenValidity()).toDate().getTime()/1000;
        accessMap.put("exp", expiresIn);
        String accessToken = JwtTokenUtil.generatorToken(accessMap);

        Map<String,Object> reAccessMap = new HashMap<>();
        accessMap.put(OAuth2Util.CLIENT_ID,tokenRequest.getOauthClientDetailDTO().getClientId());
        String refreshToken = JwtTokenUtil.generatorToken(reAccessMap);


        OAuth2AccessToken oAuth2AccessToken = new OAuth2AccessToken();
        oAuth2AccessToken.setAccess_token(accessToken);
        oAuth2AccessToken.setExpires_in(expiresIn);
        oAuth2AccessToken.setRefresh_token(refreshToken);

        return oAuth2AccessToken;
    }

    protected void verifyInfo(TokenRequest tokenRequest) {
        String clientId = tokenRequest.getRequestParameters().get(OAuth2Util.CLIENT_ID);
        if(clientId!=null){
            if(!tokenRequest.getOauthClientDetailDTO().getClientId().equals(clientId)){
                throw new Oauth2Exception(Oauth2ErrorType.PARAMETER_ERROR,"传入clientId不同");
            }
        }else{
            throw new Oauth2Exception(Oauth2ErrorType.MISSING_PARAMETER,"缺少client_id");
        }

    }

}
