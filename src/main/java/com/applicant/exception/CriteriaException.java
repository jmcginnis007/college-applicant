package com.applicant.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CriteriaException extends Exception {

	private static final long serialVersionUID = 1486174575293966041L;

	public CriteriaException(String string) {
		super(string);
	}

}
