package com.insside.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insside.model.Invoice;
@Repository
public interface  InvoiceDAO extends JpaRepository<Invoice, Integer>  {


}
