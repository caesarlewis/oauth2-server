package com.jasonless.oauth2.web.controller;

import com.jasonless.oauth2.web.entity.vo.OAuth2AccessToken;
import com.jasonless.oauth2.web.exception.Oauth2Exception;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author LiuShiZeng
 */
public class Oauth2Controller {

    @PostMapping("/oauth/token")
    @ResponseBody
    public OAuth2AccessToken postAccessToken(@RequestParam Map<String, String> parameters, @RequestHeader Map<String,String> headers) throws Oauth2Exception {
        System.out.println(parameters);
        System.out.println(headers);
        //验证header参数
     //   OauthClientDetail oauthClientDetail = headerBasicAuthService.verifyBasicAuth(headers);
        //生成tokenRequest
    //    TokenRequest tokenRequest = tokenRequestService.createTokenRequest(parameters,oauthClientDetail);

        //生成token

    //    Map<String,String> res = oauth2TokenFactory.getOauth2TokenGenerator(oauth2TokenFactory.getOauth2GrantTypeClass(tokenRequest.getGrantType())).generatorToken(tokenRequest.getGrantType(),tokenRequest,oauthClientDetail);


    //    return  ResponseData.ok(res);
        return null;

    }


    @RequestMapping(value = "/authorizationlogin")
    public String authorize(@RequestParam Map<String, String> parameters,String username, String password) throws Oauth2Exception {


//        AuthorizeRequest authorizeRequest = authorizeRequestService.createAuthorizeRequest(parameters);
//        authorizeRequest.getApprovalParameters().put("username",username);
//        authorizeRequest.getApprovalParameters().put("password",password);
//        String url = oauth2AuthorizationAuthorizeService.getRedirectUriCode(authorizeRequest);

  //      return url;
        return null;
    }

}
