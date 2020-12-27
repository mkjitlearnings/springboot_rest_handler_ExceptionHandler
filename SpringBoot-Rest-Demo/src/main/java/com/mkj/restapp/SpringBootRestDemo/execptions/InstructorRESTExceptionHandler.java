package com.mkj.restapp.SpringBootRestDemo.execptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // advices apply to the controller
public class InstructorRESTExceptionHandler {

	// add exception handler
	@ExceptionHandler
	public ResponseEntity<CustomInstructorErrorResponse> abc(DuplicateInstructorIdException e)
	{
		// 1. Create Custom Error Response 
		
		CustomInstructorErrorResponse error = new CustomInstructorErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Record already avilable");
		// 2. return response entity
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	
}
