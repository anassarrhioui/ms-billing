package me.arrhioui.billingservice.controller;

import me.arrhioui.billingservice.dto.InvoiceRequestDTO;
import me.arrhioui.billingservice.dto.InvoiceResponseDTO;
import me.arrhioui.billingservice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    final private InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public List<InvoiceResponseDTO> getAllInvoices(){
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable String id){
        return invoiceService.getInvoice(Long.parseLong(id));
    }

    @GetMapping("/customer/{id}")
    public List<InvoiceResponseDTO> getInvoicesList(@PathVariable String id){
        return invoiceService.invoicesBycustomerId(Long.parseLong(id));
    }

    @PostMapping
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO){
        return invoiceService.save(invoiceRequestDTO);
    }
}

