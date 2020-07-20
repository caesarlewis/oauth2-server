package com.jasonless.oauth2.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jasonless.oauth2.admin.entity.po.OauthClientDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author LiuShiZeng
 */
@Mapper
@Repository
public interface OauthClientDetailMapper extends BaseMapper<OauthClientDetail> {
}
