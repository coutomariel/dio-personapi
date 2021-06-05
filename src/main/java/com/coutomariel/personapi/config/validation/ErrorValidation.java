package com.coutomariel.personapi.config.validation;

public abstract class ErrorValidation {

	private String mesage;

	public ErrorValidation(String field, String message) {
		this.mesage = message;
	}

	public String getMessage() {
		return mesage;
	}

}
