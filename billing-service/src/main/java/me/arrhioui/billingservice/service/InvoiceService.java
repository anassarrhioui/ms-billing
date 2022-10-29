package me.arrhioui.billingservice.service;

import me.arrhioui.billingservice.dto.InvoiceRequestDTO;
import me.arrhioui.billingservice.dto.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO getInvoice(Long id);
    List<InvoiceResponseDTO> getAllInvoices();
    List<InvoiceResponseDTO> invoicesBycustomerId(Long id);
}
