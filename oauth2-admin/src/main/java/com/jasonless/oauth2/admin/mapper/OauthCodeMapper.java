package com.jasonless.oauth2.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jasonless.oauth2.admin.entity.po.OauthClientDetail;
import com.jasonless.oauth2.admin.entity.po.OauthCode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author LiuShiZeng
 */
@Mapper
@Repository
public interface OauthCodeMapper extends BaseMapper<OauthCode> {
}
