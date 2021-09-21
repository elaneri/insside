package com.insside.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.insside.dto.InvoiceDTO;

@Entity(name = "Invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer invoice_id;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_invoice")
	private List<InvoiceLine> invoice_line = new ArrayList<>();

	private double total;
	private int client_id;

	private java.util.Date date;

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public Invoice getInvoiceParent() {
		Invoice inv = new Invoice();
		inv.setClient_id(this.client_id);
		inv.setDate(this.date);
		inv.setTotal(this.total);
		return inv;
	}

	public InvoiceDTO toDTO() {
		InvoiceDTO dto = new InvoiceDTO();
		dto.setClient_id(this.client_id);
		dto.setDate(this.date);
		dto.setInvoice_id(this.invoice_id);
		dto.setTotal(this.total);
		for (InvoiceLine invoiceLine : invoice_line) {
		
			dto.addInvoice_line(invoiceLine.toDTO());
		}
		
		
		return dto;
	}

	public void setInvoice_id(Integer invoice_id) {
		this.invoice_id = invoice_id;

	}


	public void addInvoice_line(InvoiceLine invoice_line) {
		this.invoice_line.add(invoice_line);
	}

}
