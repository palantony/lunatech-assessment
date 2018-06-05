package com.lunatech.poc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LunatechException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LunatechException() {
        super();
    }

    public LunatechException(String message) {
        super(message);
    }

    public LunatechException(String message, Throwable cause) {
        super(message, cause);
    }
}