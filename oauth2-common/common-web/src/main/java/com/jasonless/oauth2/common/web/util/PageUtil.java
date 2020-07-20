package com.jasonless.oauth2.common.web.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author LiuShiZeng
 */
public class PageUtil {

    /**
     * 获取page参数，用于分页查询参数
     *
     * @return
     */
    public static Page getPage(long current, long size) {
        return new Page(current, size);
    }
}
