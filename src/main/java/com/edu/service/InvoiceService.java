package com.edu.service;

import java.util.List;

import javax.validation.Valid;

import com.edu.dao.Invoice;
import com.edu.error.GlobalException;

public interface InvoiceService {

	public List<Invoice> getAllInvoice();

	public Invoice getInvoiceById(Integer invoiceid) throws GlobalException;

	public void deleleInvoiceById(Integer invoiceid) throws GlobalException;

	public Invoice updateInvoiceById(Integer invoiceid, @Valid Invoice invoice) throws GlobalException;

	public Invoice saveInvoice(@Valid Invoice invoice);

}
