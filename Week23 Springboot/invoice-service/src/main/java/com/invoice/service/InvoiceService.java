package com.invoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.entity.InvoiceEntity;
import com.invoice.repository.InvoiceRepository;
import com.invoice.request.InvoiceRequest;

@Service
public class InvoiceService {
	
	@Autowired
	InvoiceRepository  invoiceRepository;

	public int createInvoice(InvoiceRequest invoiceRequest)
	{
		InvoiceEntity invoiceEntity = new InvoiceEntity();
		invoiceEntity.setInvValue(invoiceRequest.getInvValue());
		invoiceEntity.setGstNo(invoiceRequest.getGstNo());
		invoiceEntity.setStatus(invoiceRequest.getStatus());
		invoiceEntity.setNote(invoiceRequest.getNote());
		invoiceEntity.setDescription(invoiceRequest.getDescription());
		
		invoiceEntity = invoiceRepository .save(invoiceEntity);
		return invoiceEntity.getInvId();
	}
	
	public List<InvoiceEntity> getAllInvoices()
	{
		return invoiceRepository.findAll();
	}
	
	
	public InvoiceEntity getInvoiceById(int invId) 
	{
	    return invoiceRepository.findById(invId)
	    		.orElseThrow(() -> new RuntimeException("Invoice not found with id : " + invId));
	}
	
	public InvoiceEntity updatedInvoice(int id, InvoiceEntity invoiceEntity) {

		InvoiceEntity existingInvoice = getInvoiceById(id);

		existingInvoice.setInvValue(invoiceEntity.getInvValue());
		existingInvoice.setGstNo(invoiceEntity.getGstNo());
		existingInvoice.setStatus(invoiceEntity.getStatus());
		existingInvoice.setNote(invoiceEntity.getNote());
		existingInvoice.setDescription(invoiceEntity.getDescription());

		return invoiceRepository.save(existingInvoice);
	}
	
	public InvoiceEntity updateInvoiceStatus(int id, String status) {

		InvoiceEntity invoiceEntity = getInvoiceById(id);
		invoiceEntity.setStatus(status);

		return invoiceRepository.save(invoiceEntity);
	}
	
	public void deleteInvoice(int id) {

		if (!invoiceRepository.existsById(id)) {
			throw new RuntimeException("Invoice not found with id : " + id);
		}

		invoiceRepository.deleteById(id);
	}
}
