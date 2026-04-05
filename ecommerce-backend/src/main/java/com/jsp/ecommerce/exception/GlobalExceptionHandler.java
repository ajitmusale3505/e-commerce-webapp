package com.jsp.ecommerce.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsp.ecommerce.entity.Users;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	
	@ExceptionHandler(exception = NoSuchResourceException.class)
	public ResponseEntity<String> NoElementPresentExpcetion(NoSuchResourceException e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatusCode.valueOf(500));
	}
}
