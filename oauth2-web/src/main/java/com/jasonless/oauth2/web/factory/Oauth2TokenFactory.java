package com.jasonless.oauth2.web.factory;

import com.jasonless.oauth2.common.core.exception.Oauth2ErrorType;
import com.jasonless.oauth2.web.domain.Oauth2GrantTypeClass;
import com.jasonless.oauth2.web.exception.Oauth2Exception;
import com.jasonless.oauth2.web.service.oauth2.Oauth2TokenGenerator;

/**
 * @author LiuShiZeng
 */
public class Oauth2TokenFactory {

    public Oauth2TokenGenerator getOauth2TokenGenerator(Oauth2GrantTypeClass oauth2GrantTypeClass){
        Oauth2TokenGenerator oauth2TokenGenerator = null;
        try{
            oauth2TokenGenerator = (Oauth2TokenGenerator)Class.forName(oauth2GrantTypeClass.getValue()).newInstance();
        }catch (Exception e){

        }
        return oauth2TokenGenerator;
    }

    public Oauth2GrantTypeClass getOauth2GrantTypeClass(String grantType){
        if(Oauth2GrantTypeClass.PASSWORD.getName().equals(grantType)){
            return Oauth2GrantTypeClass.PASSWORD;
        }else if(Oauth2GrantTypeClass.AUTHORIZATION_CODE.getName().equals(grantType)){
            return Oauth2GrantTypeClass.AUTHORIZATION_CODE;
        }else if(Oauth2GrantTypeClass.CLIENT_CREDENTIALS.getName().equals(grantType)){
            return Oauth2GrantTypeClass.CLIENT_CREDENTIALS;
        }else if(Oauth2GrantTypeClass.IMPLICIT.getName().equals(grantType)){
            return Oauth2GrantTypeClass.IMPLICIT;
        }else{
            throw new Oauth2Exception(Oauth2ErrorType.GRANT_TYPE_ERROR);
        }
    }


}
