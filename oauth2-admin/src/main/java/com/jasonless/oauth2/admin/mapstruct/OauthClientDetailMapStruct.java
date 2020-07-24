package com.jasonless.oauth2.admin.mapstruct;

import com.jasonless.oauth2.admin.entity.po.OauthClientDetail;
import com.jasonless.oauth2.api.entity.dto.OauthClientDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author LiuShiZeng
 */
@Mapper
public interface OauthClientDetailMapStruct {

    OauthClientDetailMapStruct INSTANCE = Mappers.getMapper(OauthClientDetailMapStruct.class);

    @Mappings({
            @Mapping(source = "clientId",target = "clientId"),
            @Mapping(source = "secretKey",target = "secretKey"),
            @Mapping(source = "clientName",target = "clientName"),
            @Mapping(source = "authorizedGrantType",target = "authorizedGrantType"),
            @Mapping(source = "redirectUri",target = "redirectUri"),
            @Mapping(source = "accessTokenValidity",target = "accessTokenValidity"),
            @Mapping(source = "refreshTokenValidity",target = "refreshTokenValidity"),
            @Mapping(source = "autoApprove",target = "autoApprove")
    })
    OauthClientDetailDTO po2dto(OauthClientDetail oauthClientDetail);


}
