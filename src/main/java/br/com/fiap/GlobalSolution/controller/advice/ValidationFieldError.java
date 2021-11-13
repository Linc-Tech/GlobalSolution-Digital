package br.com.fiap.GlobalSolution.controller.advice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationFieldError {

	private String field;
	private String error;
}
