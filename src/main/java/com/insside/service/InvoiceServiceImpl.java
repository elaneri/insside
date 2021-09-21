package com.insside.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insside.dao.InvoiceDAO;
import com.insside.dto.InvoiceDTO;
import com.insside.dto.InvoiceLineDTO;
import com.insside.model.Invoice;

@Service
@Transactional(readOnly = false)
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceDAO invoiceDAO;
	@Autowired
	InvoiceLineServiceImpl InvoiceLineService;

	@Override
	public Integer save(InvoiceDTO invoice) {
		Invoice invoiceEnt = invoice.toEntity();
		
		invoiceDAO.save(invoiceEnt);
		
		InvoiceDTO dto = invoiceEnt.toDTO();
	
		return dto.getInvoice_id();
	}

	@Override
	public List<InvoiceDTO> getAll() {

		List<InvoiceDTO> invsDAO = new ArrayList<InvoiceDTO>();

		List<Invoice> invs = invoiceDAO.findAll();
		for (Invoice invoice : invs) {
			invsDAO.add(invoice.toDTO());
		}

		return invsDAO;
	}

	public InvoiceDTO findById(int id) {
		Optional<Invoice> invoice = invoiceDAO.findById(id);
		Invoice invEnt = invoice.get();
		InvoiceDTO invdto= invEnt.toDTO();
		List<InvoiceLineDTO> invlndto = InvoiceLineService.findAllById(invEnt);
		invdto.setLines(invlndto);
		
		return invdto;
	}

}
