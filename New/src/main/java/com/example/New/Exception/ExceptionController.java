package com.example.New.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(VehicleNotFoundException.class)
	public String handleException(VehicleNotFoundException e) {

		return e.getMessage();
	}

}
