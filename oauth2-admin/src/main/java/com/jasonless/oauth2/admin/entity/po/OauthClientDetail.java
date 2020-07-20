package com.jasonless.oauth2.admin.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jasonless.oauth2.common.web.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LiuShiZeng
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("oauth_client_detail")
public class OauthClientDetail extends BasePo {

    @TableId(type = IdType.INPUT)
    private String clientId;

    private String secretKey;

    private String clientName;

    private String authorizedGrantType;

    private String redirectUri;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String autoApprove;

}

