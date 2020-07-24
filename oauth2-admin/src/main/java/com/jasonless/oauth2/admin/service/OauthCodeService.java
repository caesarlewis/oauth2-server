package com.jasonless.oauth2.admin.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jasonless.oauth2.admin.entity.po.OauthClientDetail;
import com.jasonless.oauth2.admin.entity.po.OauthCode;
import com.jasonless.oauth2.admin.mapper.OauthClientDetailMapper;
import com.jasonless.oauth2.admin.mapper.OauthCodeMapper;
import org.springframework.stereotype.Service;


/**
 * @author LiuShiZeng
 */
@Service
public class OauthCodeService extends ServiceImpl<OauthCodeMapper, OauthCode> {
}
