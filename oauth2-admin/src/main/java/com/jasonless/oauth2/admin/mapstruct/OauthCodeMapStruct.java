package com.jasonless.oauth2.admin.mapstruct;

import com.jasonless.oauth2.admin.entity.po.OauthCode;
import com.jasonless.oauth2.api.entity.dto.OauthCodeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author LiuShiZeng
 */
@Mapper
public interface OauthCodeMapStruct {

    OauthCodeMapStruct INSTANCE = Mappers.getMapper(OauthCodeMapStruct.class);

    @Mappings({
            @Mapping(source = "code",target = "code"),
            @Mapping(source = "clientId",target = "clientId"),
            @Mapping(source = "userId",target = "userId")
    })
    OauthCodeDTO po2dto(OauthCode oauthCode);



}
