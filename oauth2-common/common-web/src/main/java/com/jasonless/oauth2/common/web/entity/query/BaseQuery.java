package com.jasonless.oauth2.common.web.entity.query;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author LiuShiZeng
 */
@Data
@Slf4j
public class BaseQuery implements Serializable {

    /**
     * 分页查询的参数，当前页数
     */
    private long current = 1;
    /**
     * 分页查询的参数，当前页面每页显示的数量
     */
    private long size = 10;


}
