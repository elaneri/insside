package com.insside.dto;

import java.io.Serializable;

import com.insside.model.Mobile;

public class MobileDTO  implements Serializable {


	private int code;

	private BrandDTO brand;

	private ModelDTO model;

	private double price;

	private boolean active;

	public BrandDTO getBrand() {
		return brand;
	}

	public void setBrand(BrandDTO brand) {
		this.brand = brand;
	}

	public ModelDTO getModel() {
		return model;
	}

	public void setModel(ModelDTO model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Mobile toEntity() {
		Mobile ent = new Mobile();
		
		ent.setActive(this.active);
		ent.setBrand(this.brand.toEntity());
		ent.setCode(this.code);
		ent.setModel(this.model.toEntity());
		ent.setPrice(this.price);
		
		return ent;
	}

}
