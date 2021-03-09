package com.cashapona.crudexample.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobelExceptionHandler extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//handle specific Exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException
	(ResourceNotFoundException exception,WebRequest request){
		
		ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
		return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
	}
		
		@ExceptionHandler(APIException.class)
		public ResponseEntity<?> handleAPIException
		(APIException exception,WebRequest request){
			
			ErrorDetails errorDetails=new ErrorDetails(new Date(), exception.getMessage(),request.getDescription(false));
			return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
		
	}
	
	//handle Globel Exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobelException
	(Exception exception,WebRequest request){
		
		ErrorDetails errorDetails=new ErrorDetails(new Date(), exception.getMessage(),request.getDescription(false));
		return new ResponseEntity(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	

}
