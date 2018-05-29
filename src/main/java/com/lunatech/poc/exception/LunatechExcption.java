package com.lunatech.poc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LunatechExcption extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LunatechExcption() {
        super();
    }

    public LunatechExcption(String message) {
        super(message);
    }

    public LunatechExcption(String message, Throwable cause) {
        super(message, cause);
    }
}