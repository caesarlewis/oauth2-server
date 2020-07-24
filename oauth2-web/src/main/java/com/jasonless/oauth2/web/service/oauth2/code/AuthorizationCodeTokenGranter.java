package com.jasonless.oauth2.web.service.oauth2.code;

import com.jasonless.oauth2.api.entity.domain.Oauth2GrantType;
import com.jasonless.oauth2.api.entity.dto.OauthCodeDTO;
import com.jasonless.oauth2.common.core.exception.Oauth2ErrorType;
import com.jasonless.oauth2.web.entity.dto.TokenRequest;
import com.jasonless.oauth2.web.entity.vo.OAuth2AccessToken;
import com.jasonless.oauth2.web.exception.Oauth2Exception;
import com.jasonless.oauth2.web.provider.OauthCodeProvider;
import com.jasonless.oauth2.web.service.oauth2.AbstractOauth2TokenGranter;
import com.jasonless.oauth2.web.util.OAuth2Util;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuShiZeng
 */
public class AuthorizationCodeTokenGranter extends AbstractOauth2TokenGranter {

    @Autowired
    private OauthCodeProvider oauthCodeProvider;

    protected AuthorizationCodeTokenGranter(String grantType) {
        super(Oauth2GrantType.CLIENT_CREDENTIALS.getValue());
    }

    @Override
    protected OAuth2AccessToken getAccessToken(TokenRequest tokenRequest) throws Oauth2Exception {
        String code = tokenRequest.getRequestParameters().get(OAuth2Util.CODE);
        OauthCodeDTO oauthCode = oauthCodeProvider.get(code);
        if(oauthCode==null){
            throw new Oauth2Exception(Oauth2ErrorType.PARAMETER_ERROR,"code不存在");
        }
        oauthCodeService.removeById(code);

        Map<String,String> res = new HashMap<String,String>();
        String token = JwtUtil.getLocalToken(SystemContext.IIS, new Date(new Date().getTime() + SystemContext.SESSION_TIME), SystemContext.SUB, oauthCode.getUserId(),
                new Date(), null);
        res.put("token", token);
        return res;

    }

    @Override
    protected void verifyInfo(TokenRequest tokenRequest) throws Oauth2Exception {
        super.verifyInfo(tokenRequest);
        String code = tokenRequest.getRequestParameters().get(OAuth2Util.CODE);
        if(code==null){
            throw new Oauth2Exception(Oauth2ErrorType.MISSING_PARAMETER,"缺少code");
        }
        String clientSecret = tokenRequest.getRequestParameters().get(OAuth2Util.CLIENT_SECRET);
        if(clientSecret==null){
            throw new Oauth2Exception(Oauth2ErrorType.MISSING_PARAMETER,"缺少client_secret");
        }

        String redirectUri = tokenRequest.getRequestParameters().get(OAuth2Util.REDIRECT_URI);
        if(redirectUri==null){
            throw new Oauth2Exception(Oauth2ErrorType.MISSING_PARAMETER,"缺少redirect_uri");
        }


    }

}
