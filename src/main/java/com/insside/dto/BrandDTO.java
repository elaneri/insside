package com.insside.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.insside.model.Brand;

public class BrandDTO  implements Serializable {
	private String name;
	private String property;


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

	public Brand toEntity() {
		Brand ent = new Brand();

		ent.setBrand_id(this.brand_id);
		ent.setName(this.name);
		ent.setProperty(this.property);

		return ent;
	}
}
