package com.jasonless.oauth2.admin.dubbo;

import com.jasonless.oauth2.admin.entity.po.OauthClientDetail;
import com.jasonless.oauth2.admin.service.OauthClientDetailService;
import com.jasonless.oauth2.api.entity.dto.OauthClientDetailDTO;
import com.jasonless.oauth2.api.service.IOauthClientDetailService;
import com.jasonless.oauth2.common.core.entity.vo.Result;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author LiuShiZeng
 */
@Service
public class OauthClientDetailDubboService implements IOauthClientDetailService {

    @Autowired
    private OauthClientDetailService oauthClientDetailService;

    @Override
    public Result<OauthClientDetailDTO> get(String clientId) {

        OauthClientDetail oauthClientDetail = oauthClientDetailService.getById(clientId);


        return null;
    }
}
