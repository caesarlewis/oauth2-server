package com.jasonless.oauth2.common.web.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.jasonless.oauth2.common.core.utils.UserContextHolder;
import com.jasonless.oauth2.common.web.entity.po.BasePo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.MetaObject;

import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author LiuShiZeng
 */
public class PoMetaObjectHandler implements MetaObjectHandler {

    /**
     * 获取当前的用户，为空返回默认system
     *
     * @return
     */
    private String getCurrentUsername() {
        return StringUtils.defaultIfBlank(UserContextHolder.getInstance().getUsername(), BasePo.DEFAULT_USERNAME);
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createdBy", getCurrentUsername(), metaObject);
        this.setFieldValByName("createdTime", Date.from(ZonedDateTime.now().toInstant()), metaObject);
        this.updateFill(metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updatedBy", getCurrentUsername(), metaObject);
        this.setFieldValByName("updatedTime", Date.from(ZonedDateTime.now().toInstant()), metaObject);

    }
}
