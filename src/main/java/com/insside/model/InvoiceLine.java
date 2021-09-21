package com.insside.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.insside.dto.InvoiceLineDTO;

@Entity(name = "InvoiceLine")
public class InvoiceLine {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer invoiceLine_id;

	@OneToOne
	@JoinColumn(name = "mobile_id", nullable = false)
	private Mobile mobile;
	
    @ManyToOne
    @JoinColumn(name = "fk_invoice")
	private Invoice invoice;

	private double amount;

	public Mobile getMobil() {
		return mobile;
	}

	public void setMobil(Mobile mobile) {
		this.mobile = mobile;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public InvoiceLineDTO toDTO() {
		InvoiceLineDTO dto = new InvoiceLineDTO();
		
		dto.setAmount(this.amount);
		dto.setMobil(this.mobile.toDTO());
		
		return dto;
	}
}
