package com.coutomariel.personapi.config.validation;

public class ErrorFieldValidation extends ErrorValidation {

	private String field;

	public ErrorFieldValidation(String field, String message) {
		super(field, message);
		this.field = field;
	}

	public String getField() {
		return field;
	}

}
