package com.example.demo.model;

public class Result {

	
	private String message;
	private Object data;
	
	public Result() {
		super();
		
	}


	public Result(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "Result [message=" + message + ", data=" + data + "]";
	}
	
	
	
	
	
}
