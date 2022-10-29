package me.arrhioui.billingservice.service;

import me.arrhioui.billingservice.dto.InvoiceRequestDTO;
import me.arrhioui.billingservice.dto.InvoiceResponseDTO;
import me.arrhioui.billingservice.entity.Customer;
import me.arrhioui.billingservice.entity.Invoice;
import me.arrhioui.billingservice.mapper.InvoiceMapper;
import me.arrhioui.billingservice.repository.InvoiceRepository;
import me.arrhioui.billingservice.rest.CustomerRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;
    private final CustomerRestClient customerRestClient;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerRestClient customerRestClient) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
        Invoice invoice = invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
        Customer customer = customerRestClient.getCustomer(invoice.getCustomerID());
        if (Objects.isNull(customer))
            throw new RuntimeException("Customer Not Found");

        invoice.setData(new Date());
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return invoiceMapper.fromInvoice(savedInvoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(Long id) {
        Invoice invoice = invoiceRepository.getById(id);
        Customer customer = customerRestClient.getCustomer(invoice.getCustomerID());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> getAllInvoices() {
        return invoiceRepository
                .findAll()
                .stream()
                .peek(c -> c.setCustomer(customerRestClient.getCustomer(c.getCustomerID())))
                .map(invoiceMapper::fromInvoice)
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponseDTO> invoicesBycustomerId(Long id) {
        Customer customer = customerRestClient.getCustomer(id);
        return invoiceRepository.findByCustomerID(id)
                .stream()
                .peek(c -> c.setCustomer(customer))
                .map(invoiceMapper::fromInvoice)
                .collect(Collectors.toList());
    }
}
