package com.insside.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.insside.model.Invoice;
import com.insside.model.InvoiceLine;

public class InvoiceDTO implements Serializable {

	private Integer invoice_id;

	private List<InvoiceLineDTO> lines = new ArrayList<>();

	private double total;
	private int client_id;

	private java.util.Date date;

	public List<InvoiceLineDTO> getLines() {
		return lines;
	}

	public void setLines(List<InvoiceLineDTO> lines) {
		this.lines = lines;
	}

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

	public Invoice toEntity() {

		Invoice entity = new Invoice();
		entity.setClient_id(this.client_id);
		entity.setDate(this.date);
		entity.setTotal(this.total);
		entity.setInvoice_id(this.invoice_id);
		for (InvoiceLineDTO invoiceLineDTO : lines) {
			entity.addInvoice_line(invoiceLineDTO.toEntity());

		}

		return entity;
	}

	public Integer getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(Integer invoice_id) {
		this.invoice_id = invoice_id;
	}
	public void addInvoice_line(InvoiceLineDTO invoice_line) {
		lines.add(invoice_line);
	}
}
