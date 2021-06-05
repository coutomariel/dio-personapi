package com.coutomariel.personapi.config.validation;

import java.util.ArrayList;
import java.util.List;

public class ErrorsResponseDto {

	private List<ErrorValidation> errors = new ArrayList<ErrorValidation>();

	public List<ErrorValidation> getErrors() {
		return errors;
	}

}
