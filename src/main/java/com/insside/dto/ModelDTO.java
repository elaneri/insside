package com.insside.dto;

import java.io.Serializable;

import com.insside.model.Model;

public class ModelDTO  implements Serializable {

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

	public Model toEntity() {
		Model ent = new Model();
		ent.setModel_id(this.model_id);
		ent.setName(this.name);
		ent.setRelease(this.release);
		return ent;
	}
}
