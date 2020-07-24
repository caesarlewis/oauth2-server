package com.jasonless.oauth2.common.web.entity.dto;

import com.jasonless.oauth2.common.web.entity.po.BasePo;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author LiuShiZeng
 */
public class BaseDTO<T extends BasePo> implements Serializable {

    public T toPo(Class<T> clazz) {
        T t = BeanUtils.instantiateClass(clazz);
        BeanUtils.copyProperties(this, t);
        return t;
    }

}
