package com.mkdata.exception;

public class ResourceConstraintViolation extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ResourceConstraintViolation() {
		super("Cliente já cadastrado!");
	}
}
