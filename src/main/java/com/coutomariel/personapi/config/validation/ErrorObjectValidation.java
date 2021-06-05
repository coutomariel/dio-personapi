package com.coutomariel.personapi.config.validation;

public class ErrorObjectValidation extends ErrorValidation {

	private String object;

	public ErrorObjectValidation(String object, String message) {
		super(object, message);
		this.object = object;
	}

	public String getObject() {
		return object;
	}

}
