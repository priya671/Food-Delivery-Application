package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.dao.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{

}
