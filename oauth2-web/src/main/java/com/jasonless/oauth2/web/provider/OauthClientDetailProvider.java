package com.jasonless.oauth2.web.provider;


import com.jasonless.oauth2.api.entity.dto.OauthClientDetailDTO;
import com.jasonless.oauth2.api.service.IOauthClientDetailService;
import com.jasonless.oauth2.common.core.entity.vo.Result;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author LiuShiZeng
 */
@Service
public class OauthClientDetailProvider {

    @Reference
    private IOauthClientDetailService oauthClientDetailService;

    public OauthClientDetailDTO get(String clientId){
        Result<OauthClientDetailDTO> result = oauthClientDetailService.get(clientId);
        if(result.isSuccess()){
            OauthClientDetailDTO detailDTO = result.getData();
            return detailDTO;
        }
        return null;
    }

}
