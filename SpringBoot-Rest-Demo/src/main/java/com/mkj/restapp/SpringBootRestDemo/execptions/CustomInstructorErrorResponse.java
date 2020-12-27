package com.mkj.restapp.SpringBootRestDemo.execptions;

public class CustomInstructorErrorResponse {
	
	private int status;
	private String message;
	public CustomInstructorErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomInstructorErrorResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
