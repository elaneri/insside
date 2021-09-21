package com.insside.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.insside.dto.BrandDTO;

@Entity(name = "Brand")
public class Brand {
	private String name;
	private String property;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int brand_id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public int getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}

	public BrandDTO toDTO() {
		BrandDTO dto = new BrandDTO();

		dto.setBrand_id(this.brand_id);
		dto.setName(this.name);
		dto.setProperty(this.property);

		return dto;
	}

}
