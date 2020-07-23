package com.jasonless.oauth2.web.exception;

import com.jasonless.oauth2.common.core.entity.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LiuShiZeng
 */
@ControllerAdvice
public class Oauth2ExceptionHandler {

    @ExceptionHandler({Oauth2Exception.class})
    @ResponseBody
    public Result<String> oauth2Exception(Oauth2Exception ex){
        ex.printStackTrace();
        return Result.fail(ex.getErrorType(),ex.getErrorType().getMsg());

    }



}
