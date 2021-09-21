package com.insside.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.insside.dto.InvoiceDTO;
import com.insside.model.Invoice;
import com.insside.model.Model;
import com.insside.service.InvoiceService;
import com.insside.service.InvoiceServiceImpl;

@RestController
public class InssideController {

	@Autowired
	private InvoiceServiceImpl invoiceService;

	@RequestMapping(value = "/invoice", method = RequestMethod.GET)
	public List<InvoiceDTO> getAll() {
		return invoiceService.getAll();
	}

	@RequestMapping(value = "/invoice/{id}", method = RequestMethod.GET)
	public InvoiceDTO findById(@PathVariable Integer id) {
		return invoiceService.findById(id);
	}

	@RequestMapping(value = "/invoice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public InvoiceDTO addClaim(@RequestBody InvoiceDTO invoice) throws Exception {
		try {
		Integer invId = invoiceService.save(invoice);
		return invoiceService.findById(invId);
		} catch (ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getReason());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR");
		}
	}

}
