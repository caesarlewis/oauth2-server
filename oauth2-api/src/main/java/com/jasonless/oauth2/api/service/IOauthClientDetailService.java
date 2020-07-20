package com.jasonless.oauth2.api.service;

import com.jasonless.oauth2.api.entity.dto.OauthClientDetailDTO;
import com.jasonless.oauth2.common.core.entity.vo.Result;

/**
 * @author LiuShiZeng
 */

public interface IOauthClientDetailService {

    Result<OauthClientDetailDTO> get(String clientId);

}
