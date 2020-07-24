package com.jasonless.oauth2.web.provider;

import com.jasonless.oauth2.api.entity.dto.OauthClientDetailDTO;
import com.jasonless.oauth2.api.entity.dto.OauthCodeDTO;
import com.jasonless.oauth2.api.service.IOauthCodeService;
import com.jasonless.oauth2.common.core.entity.vo.Result;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiuShiZeng
 */
@Service
public class OauthCodeProvider {

    @Reference
    private IOauthCodeService oauthCodeService;

    public OauthCodeDTO get(String code){
        Result<OauthCodeDTO> result = oauthCodeService.get(code);
        if(result.isSuccess()){
            OauthCodeDTO detailDTO = result.getData();
            return detailDTO;
        }
        return null;
    }

}
