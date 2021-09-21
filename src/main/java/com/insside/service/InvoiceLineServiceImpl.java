package com.insside.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insside.dao.InvoiceDAO;
import com.insside.dao.InvoiceLineDAO;
import com.insside.dto.InvoiceDTO;
import com.insside.dto.InvoiceLineDTO;
import com.insside.model.Invoice;
import com.insside.model.InvoiceLine;

@Service
@Transactional(readOnly = false)
public class InvoiceLineServiceImpl implements InvoiceLineService {
	@Autowired
	InvoiceLineDAO invoiceLineDAO;

	@Override
	public InvoiceLineDTO save(InvoiceLineDTO invoiceline) {
		InvoiceLine invl = invoiceline.toEntity();

		invoiceLineDAO.save(invl);
		return invl.toDTO();
	}
	
	
	@Override
	public List<InvoiceLineDTO> findAllById(Invoice inv) {

		List<InvoiceLineDTO> invslnDAO = new ArrayList<InvoiceLineDTO>();

		List<InvoiceLine> invsl = invoiceLineDAO.findAllById(inv);
		for (InvoiceLine invoice : invsl) {
			invslnDAO.add(invoice.toDTO());
		}

		return invslnDAO;
	}

}
