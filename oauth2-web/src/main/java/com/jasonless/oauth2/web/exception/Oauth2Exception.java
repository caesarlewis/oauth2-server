package com.jasonless.oauth2.web.exception;

import com.jasonless.oauth2.common.core.exception.BaseException;
import com.jasonless.oauth2.common.core.exception.IErrorType;
import com.jasonless.oauth2.common.core.exception.Oauth2ErrorType;

public class Oauth2Exception extends BaseException {

	public Oauth2Exception() {
	}

	public Oauth2Exception(IErrorType errorType) {
		super(errorType);
	}

	public Oauth2Exception(IErrorType errorType, String message) {
		super(errorType, message);
	}

	public Oauth2Exception(IErrorType errorType, String message, Throwable cause) {
		super(errorType, message, cause);
	}
}
