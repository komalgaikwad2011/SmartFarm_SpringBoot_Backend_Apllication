package com.smartfarm.farmerweb.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.smartfarm.farmerweb.Payload.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	 
	@ExceptionHandler(FarmerNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleFarmerNotFoundException(FarmerNotFoundException ex,HttpServletRequest request)
	{
		ErrorResponse errorResponse=new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(),
				ex.getMessage(),
				request.getRequestURI()
				
				);
		
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(DublicateEmailException.class)
	public ResponseEntity<ErrorResponse> handleDublicateEmailException(DublicateEmailException ex,HttpServletRequest request)
	{
		ErrorResponse errorResponse=new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.CONFLICT.value(),
				HttpStatus.CONFLICT.getReasonPhrase(),
				ex.getMessage(),
				request.getRequestURI()
				
				);
		
		return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
		
	}
}
