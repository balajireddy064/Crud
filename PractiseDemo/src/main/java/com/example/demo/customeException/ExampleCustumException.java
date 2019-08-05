package com.example.demo.customeException;

public class ExampleCustumException extends Exception {

	public ExampleCustumException(String message) {
		System.out.println("well come to exception");
		super(message);
	}

}
