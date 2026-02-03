package com.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.invoice.InvoiceServiceApplication;
import com.invoice.entity.InvoiceEntity;
import com.invoice.request.InvoiceRequest;
import com.invoice.service.InvoiceService;


@RestController
public class InvoiceController {

    private final InvoiceServiceApplication invoiceServiceApplication;

	
	@Autowired
	InvoiceService invoiceService;

    InvoiceController(InvoiceServiceApplication invoiceServiceApplication) {
        this.invoiceServiceApplication = invoiceServiceApplication;
    }
	
	@PostMapping("generateInvoice")
	public String generateInvoice(@RequestBody InvoiceRequest invoiceRequest)
	{
		int invId = invoiceService.createInvoice(invoiceRequest);
		return "Your Invoice has been generated successfully. Invoice id is : "+ invId;
	}
	
	@GetMapping("all")
	public List<InvoiceEntity> getAllInvoices()
	{
		return invoiceService.getAllInvoices();
	}
	
	@GetMapping("{id}")
	public InvoiceEntity getInvoiceById(@PathVariable int invId)
	{
		return invoiceService.getInvoiceById(invId);
	}
	
	@PutMapping({"id"})
	public InvoiceEntity updatedInvoice(@PathVariable int invId, @RequestBody InvoiceEntity invoiceEntity)
	{
		return invoiceService.updatedInvoice(invId,invoiceEntity);
	}
	
	@PatchMapping("{id}/status")
	public InvoiceEntity updateInvoiceStatus(
			@PathVariable int invId,
			@RequestParam String status) {

		return invoiceService.updateInvoiceStatus(invId, status);
	}
	
	@DeleteMapping("{id}")
	public String deleteInvoice(@PathVariable int id) {
		invoiceService.deleteInvoice(id);
		return "Invoice deleted successfully";
	}
}
