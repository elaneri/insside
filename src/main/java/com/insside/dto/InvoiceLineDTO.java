package com.insside.dto;

import java.io.Serializable;

import com.insside.model.Invoice;
import com.insside.model.InvoiceLine;

public class InvoiceLineDTO implements Serializable {
	
	
	private MobileDTO mobile;
	private double amount;
	private Integer invoiceLine_id;
	private InvoiceDTO invoice;
	public MobileDTO getMobil() {
		return mobile;
	}

	public void setMobil(MobileDTO mobile) {
		this.mobile = mobile;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public InvoiceLine toEntity() {
		InvoiceLine ent = new InvoiceLine();
		
		ent.setAmount(this.amount);
		ent.setMobil(this.mobile.toEntity());
		if(this.invoice!=null)
		ent.setInvoice(this.invoice.toEntity());
		return ent;
	}

	public Integer getInvoiceLine_id() {
		return invoiceLine_id;
	}

	public void setInvoiceLine_id(Integer invoiceLine_id) {
		this.invoiceLine_id = invoiceLine_id;
	}

	public InvoiceDTO getInvoice() {
		return invoice;
	}

	public void setInvoice(InvoiceDTO invoice) {
		this.invoice = invoice;
	}




}
