package com.coutomariel.personapi.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDto {
	private String message;
}
