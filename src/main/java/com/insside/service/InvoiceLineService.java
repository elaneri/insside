package com.insside.service;

import java.util.List;

import com.insside.dto.InvoiceDTO;
import com.insside.dto.InvoiceLineDTO;
import com.insside.model.Invoice;

public interface InvoiceLineService {
	public InvoiceLineDTO save(InvoiceLineDTO invoiceline);

	public List<InvoiceLineDTO> findAllById(Invoice inv);

}
