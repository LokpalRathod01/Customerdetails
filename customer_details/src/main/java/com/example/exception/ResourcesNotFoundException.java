package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourcesNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fieldName;
	private Object fieldvalue;
	public ResourcesNotFoundException(String resourceName, String fieldName, Object fieldvalue) {
		super(String.format("%s customer details not found with %s:'%s'",resourceName,fieldName,fieldvalue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldvalue = fieldvalue;
		
		
	}
	public String getResourceName() {
		return resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public Object getFieldvalue() {
		return fieldvalue;
	}

}
