package com.jasonless.oauth2.admin.entity.query;

import com.jasonless.oauth2.common.web.entity.query.BaseQuery;
import lombok.Data;

/**
 * @author LiuShiZeng
 */
@Data
public class OauthClientDetailQuery extends BaseQuery {

    private String clientName;

}
