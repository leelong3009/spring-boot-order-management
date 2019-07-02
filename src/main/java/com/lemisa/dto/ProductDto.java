package com.lemisa.dto;

import java.math.BigDecimal;

import com.google.gson.annotations.Expose;

public class ProductDto {
	@Expose
	private Long id;
	@Expose
	private String name;
	@Expose
	private BigDecimal price;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
