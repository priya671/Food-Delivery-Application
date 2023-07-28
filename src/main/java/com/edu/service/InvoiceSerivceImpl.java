package com.edu.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Invoice;
import com.edu.error.GlobalException;
import com.edu.repository.InvoiceRepository;

@Service
public class InvoiceSerivceImpl implements InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;

//	@Override
//	public Invoice saveInvoice(@Valid Invoice invoice) {
//		// TODO Auto-generated method stub
//		return invoiceRepository.save(invoice);
//	}

	@Override
	public List<Invoice> getAllInvoice() {
		// TODO Auto-generated method stub
		return invoiceRepository.findAll();
	}

	@Override
	public Invoice getInvoiceById(Integer invoiceid) throws GlobalException {
		// TODO Auto-generated method stub
		Optional<Invoice> obj = invoiceRepository.findById(invoiceid);
		
		if(!obj.isPresent())
			throw new GlobalException("invoice id "+invoiceid+" is not found");
		else
			return invoiceRepository.findById(invoiceid).get();
	}

	@Override
	public void deleleInvoiceById(Integer invoiceid) throws GlobalException {
		// TODO Auto-generated method stub
		Optional<Invoice> obj = invoiceRepository.findById(invoiceid);
		
		if(!obj.isPresent())
			throw new GlobalException("invoice id "+invoiceid+" is not found");
		else
			invoiceRepository.deleteById(invoiceid);
	}

	@Override
	public Invoice updateInvoiceById(Integer invoiceid, @Valid Invoice invoice) throws GlobalException {
		// TODO Auto-generated method stub
		Invoice bill = null;
		Optional<Invoice> obj = invoiceRepository.findById(invoiceid);
		
		if(!obj.isPresent())
			throw new GlobalException("invoice id "+invoiceid+" is not found");
		else {
			bill = invoiceRepository.findById(invoiceid).get();
			
			bill.setInvoicetotalitem(invoice.getInvoicetotalitem());
			bill.setInvoicetotalcost(invoice.getInvoicetotalcost());
			
			return invoiceRepository.save(bill);
		}
	}

	@Override
	public Invoice saveInvoice(@Valid Invoice invoice) {
		// TODO Auto-generated method stub
		return invoiceRepository.save(invoice);
	}
}
