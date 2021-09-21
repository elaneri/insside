package com.insside.service;

import java.util.List;
import java.util.Optional;


import com.insside.dto.InvoiceDTO;
import com.insside.model.Invoice;


public interface InvoiceService {

	public Integer save(InvoiceDTO invoice);

	public List<InvoiceDTO> getAll();

	public InvoiceDTO findById(int id);

}
