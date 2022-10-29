package me.arrhioui.billingservice.mapper;

import me.arrhioui.billingservice.dto.InvoiceRequestDTO;
import me.arrhioui.billingservice.dto.InvoiceResponseDTO;
import me.arrhioui.billingservice.entity.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO fromInvoice(Invoice invoice);
}
