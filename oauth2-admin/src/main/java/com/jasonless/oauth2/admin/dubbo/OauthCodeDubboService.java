package com.jasonless.oauth2.admin.dubbo;

import com.jasonless.oauth2.admin.entity.po.OauthClientDetail;
import com.jasonless.oauth2.admin.entity.po.OauthCode;
import com.jasonless.oauth2.admin.mapstruct.OauthCodeMapStruct;
import com.jasonless.oauth2.admin.service.OauthCodeService;
import com.jasonless.oauth2.api.entity.dto.OauthCodeDTO;
import com.jasonless.oauth2.api.service.IOauthCodeService;
import com.jasonless.oauth2.common.core.entity.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author LiuShiZeng
 */
@Service
@Slf4j
public class OauthCodeDubboService implements IOauthCodeService {

    @Autowired
    private OauthCodeService oauthCodeService;

    @Override
    public Result<OauthCodeDTO> get(String code) {

        log.info("OauthCodeDubboService get with {}","start");
        try{
            OauthCode oauthCode = oauthCodeService.getById(code);

            OauthCodeDTO codeDTO = OauthCodeMapStruct.INSTANCE.po2dto(oauthCode);

            return Result.success(codeDTO);
        }catch (Exception e){
            log.error("OauthCodeDubboService get with code:{},exception:{}",code,e.getMessage());
            return Result.fail();
        }finally {
            log.info("OauthCodeDubboService get with {}","end");
        }
    }

    @Override
    public Result remove(String code) {
        log.info("OauthCodeDubboService remove with {}","start");
        try{
            boolean flag = oauthCodeService.removeById(code);


            return Result.success(flag);
        }catch (Exception e){
            log.error("OauthCodeDubboService remove with code:{},exception:{}",code,e.getMessage());
            return Result.fail();
        }finally {
            log.info("OauthCodeDubboService remove with {}","end");
        }
    }
}
