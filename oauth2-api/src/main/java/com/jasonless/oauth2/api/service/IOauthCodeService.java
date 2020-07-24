package com.jasonless.oauth2.api.service;

import com.jasonless.oauth2.api.entity.dto.OauthClientDetailDTO;
import com.jasonless.oauth2.api.entity.dto.OauthCodeDTO;
import com.jasonless.oauth2.common.core.entity.vo.Result;

/**
 * @author LiuShiZeng
 */
public interface IOauthCodeService {

    Result<OauthCodeDTO> get(String code);

    Result<Boolean> remove(String code);

}
