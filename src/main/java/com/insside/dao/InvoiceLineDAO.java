package com.insside.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insside.model.Invoice;
import com.insside.model.InvoiceLine;
@Repository
public interface InvoiceLineDAO extends JpaRepository<InvoiceLine, Integer>  {
	
	
	@Query("select l from InvoiceLine l where l.invoice = ?1")
	public List<InvoiceLine> findAllById(Invoice inv);
}
