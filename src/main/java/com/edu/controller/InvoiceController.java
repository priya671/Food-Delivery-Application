package com.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.Invoice;
import com.edu.error.GlobalException;
import com.edu.service.InvoiceService;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	
	@PostMapping("/saveInvoice")
	public ResponseEntity<Invoice> saveInvoice(@Valid @RequestBody Invoice invoice){
		Invoice inv = invoiceService.saveInvoice(invoice);
		
		return new ResponseEntity<Invoice>(inv, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllInvoice")
	public List<Invoice> getAllInvoice(){
		return invoiceService.getAllInvoice();
	}
	
	@GetMapping("/getInvoiceById/{oid}")
	public Invoice getInvoiceById(@PathVariable("oid") Integer invoiceid) throws GlobalException {
		return invoiceService.getInvoiceById(invoiceid);
	}
	
	@DeleteMapping("/deleleInvoiceById/{oid}")
	public String deleleInvoiceById(@PathVariable("oid") Integer invoiceid) throws GlobalException {
		invoiceService.deleleInvoiceById(invoiceid);
		
		return "record deleted";
	}
	
	@PutMapping("/updateInvoiceById/{oid}")
	public Invoice updateInvoiceById(@PathVariable("oid") Integer invoiceid, @Valid @RequestBody Invoice invoice) throws GlobalException {
		return invoiceService.updateInvoiceById(invoiceid,invoice);
	}
}
