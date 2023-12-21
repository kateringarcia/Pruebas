package com.coralogix.calculator.model;

public class Result {

	private int statuscode;
	private Film response;


	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public Film getResponse() {
		return response;
	}

	public void setResponse(Film bodyRTA) {
		this.response = bodyRTA;
	}

}
