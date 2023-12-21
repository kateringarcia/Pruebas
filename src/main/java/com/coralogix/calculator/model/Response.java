package com.coralogix.calculator.model;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Response {

	private HttpClient client;
	private HttpRequest request;

	public HttpClient getClient() {
		return client;
	}

	public void setClient(HttpClient client) {
		this.client = client;
	}

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

}
