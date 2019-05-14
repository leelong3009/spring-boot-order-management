package com.lemisa.dto;

import com.google.gson.annotations.Expose;

public class CustomerDto {
	@Expose
	private String name;
	@Expose
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
