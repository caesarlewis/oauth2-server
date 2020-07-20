package com.jasonless.oauth2.admin.controller;

import com.jasonless.oauth2.admin.entity.po.OauthClientDetail;
import com.jasonless.oauth2.admin.entity.query.OauthClientDetailQuery;
import com.jasonless.oauth2.admin.service.OauthClientDetailService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author LiuShiZeng
 */
@RestController
@RequestMapping("/oauthclientdetail")
public class OauthClientDetailController {

    private final OauthClientDetailService oauthClientDetailService;

    public OauthClientDetailController(OauthClientDetailService oauthClientDetailService) {
        this.oauthClientDetailService = oauthClientDetailService;
    }

    @PostMapping("")
    public void add(@RequestBody OauthClientDetail oauthClientDetail){
        oauthClientDetailService.save(oauthClientDetail);
    }

    @PutMapping("")
    public void update(@RequestBody OauthClientDetail oauthClientDetail){
        oauthClientDetailService.updateById(oauthClientDetail);
    }

    @DeleteMapping("/{clientId}")
    public void delete(@PathVariable String clientId){
        oauthClientDetailService.removeById(clientId);
    }

    @GetMapping("/{clientId}")
    public OauthClientDetail get(@PathVariable String clientId){
        return oauthClientDetailService.getById(clientId);
    }


}
