package com.jasonless.oauth2.admin.controller;

import com.jasonless.oauth2.admin.entity.po.OauthClientDetail;
import com.jasonless.oauth2.admin.entity.po.OauthCode;
import com.jasonless.oauth2.admin.service.OauthClientDetailService;
import com.jasonless.oauth2.admin.service.OauthCodeService;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiuShiZeng
 */
@RestController
@RequestMapping("/oauthcode")
public class OauthCodeController {

    private final OauthCodeService oauthCodeService;

    public OauthCodeController(OauthCodeService oauthCodeService) {
        this.oauthCodeService = oauthCodeService;
    }

    @PostMapping("")
    public void add(@RequestBody OauthCode oauthCode){
        oauthCodeService.save(oauthCode);
    }

    @PutMapping("")
    public void update(@RequestBody OauthCode oauthCode){
        oauthCodeService.updateById(oauthCode);
    }

    @DeleteMapping("/{clientId}")
    public void delete(@PathVariable String oauthCode){
        oauthCodeService.removeById(oauthCode);
    }

    @GetMapping("/{clientId}")
    public OauthCode get(@PathVariable String oauthCode){
        return oauthCodeService.getById(oauthCode);
    }

}
