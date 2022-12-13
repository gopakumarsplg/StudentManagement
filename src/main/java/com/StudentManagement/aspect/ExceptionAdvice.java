package com.StudentManagement.aspect;

import com.StudentManagement.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@RestControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

	@Autowired
	private ResourceBundle resourceBundle;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler#handleMethodArgumentNotValid(org.springframework.web.bind.MethodArgumentNotValidException, org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus, org.springframework.web.context.request.WebRequest)
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<String>();
	    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
	        errors.add(retrieveMessage(error.getDefaultMessage()));
	    }
	    for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
	        errors.add(retrieveMessage(error.getDefaultMessage()));
	    }
	    ResultDto result = new ResultDto(false, errors.isEmpty()? "Method Argument Not Valid" : errors.get(0), 0);
		return new ResponseEntity<>(result, status);
	}

	private String retrieveMessage(String key) {
		if (key != null && key.startsWith("#")) {
			return resourceBundle.getString(key.replace("#", ""));
		}
		return key;
	}



}
