package com.business;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@SuppressWarnings("unused")
@ControllerAdvice
public class Exceptions
{
	public String handler()
	{
		System.out.println("Exception Handled....!!!!");
		return "exception";
	}

}
