package com.insside.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.insside.dto.ModelDTO;

@Entity(name = "Model")
public class Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int model_id;

	private java.util.Date release;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.util.Date getRelease() {
		return release;
	}

	public void setRelease(java.util.Date release) {
		this.release = release;
	}

	public int getModel_id() {
		return model_id;
	}

	public void setModel_id(int model_id) {
		this.model_id = model_id;
	}

	public ModelDTO toDTO() {
		ModelDTO dto = new ModelDTO();
		dto.setModel_id(this.model_id);
		dto.setName(this.name);
		dto.setRelease(this.release);
		return dto;
	}

}
