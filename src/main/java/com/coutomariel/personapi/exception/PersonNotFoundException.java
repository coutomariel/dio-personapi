package com.coutomariel.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PersonNotFoundException extends HttpStatusCodeException {

	private static final long serialVersionUID = -4560532949002428309L;

	static HttpStatus status = HttpStatus.NOT_FOUND;

	public PersonNotFoundException(final String statusText) {
		super(status, statusText);
	}
}