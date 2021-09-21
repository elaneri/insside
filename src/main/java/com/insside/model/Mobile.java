package com.insside.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.insside.dto.MobileDTO;

@Entity(name = "Mobile")
public class Mobile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;

	@OneToOne
	@JoinColumn(name = "brand_id", nullable = false)
	private Brand brand;

	@OneToOne
	@JoinColumn(name = "model_id", nullable = false)
	private Model model;

	private double price;

	private boolean active;

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
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

	public MobileDTO toDTO() {
		MobileDTO dto = new MobileDTO();
		
		dto.setActive(this.active);
		dto.setBrand(this.brand.toDTO());
		dto.setCode(this.code);
		dto.setModel(this.model.toDTO());
		dto.setPrice(this.price);
		
		return dto;
	}

}
