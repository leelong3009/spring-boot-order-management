package com.lemisa.dto;

import com.google.gson.annotations.Expose;

public class CustomerDto {
	@Expose
	private Long id;
	@Expose
	private String name;
	@Expose
	private String email;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
