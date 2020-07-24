package com.jasonless.oauth2.admin.dubbo;

import com.jasonless.oauth2.admin.entity.po.OauthClientDetail;
import com.jasonless.oauth2.admin.mapstruct.OauthClientDetailMapStruct;
import com.jasonless.oauth2.admin.service.OauthClientDetailService;
import com.jasonless.oauth2.api.entity.dto.OauthClientDetailDTO;
import com.jasonless.oauth2.api.service.IOauthClientDetailService;
import com.jasonless.oauth2.common.core.entity.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author LiuShiZeng
 */
@Service
@Slf4j
public class OauthClientDetailDubboService implements IOauthClientDetailService {

    @Autowired
    private OauthClientDetailService oauthClientDetailService;

    @Override
    public Result<OauthClientDetailDTO> get(String clientId) {
        log.info("oauthClientDetailService with {}","start");
        try{
            OauthClientDetail oauthClientDetail = oauthClientDetailService.getById(clientId);
            OauthClientDetailDTO detailDTO = OauthClientDetailMapStruct.INSTANCE.po2dto(oauthClientDetail);
            return Result.success(detailDTO);
        }catch (Exception e){
            log.error("oauthClientDetailService with clientId:{},exception:{}",clientId,e.getMessage());
            return Result.fail();
        }finally {
            log.info("oauthClientDetailService with {}","end");
        }


    }
}
