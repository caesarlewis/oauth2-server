package com.jasonless.oauth2.admin.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jasonless.oauth2.common.web.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LiuShiZeng
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("oauth_code")
public class OauthCode extends BasePo {

    private String code;

    private String clientId;

    private String userId;

}
