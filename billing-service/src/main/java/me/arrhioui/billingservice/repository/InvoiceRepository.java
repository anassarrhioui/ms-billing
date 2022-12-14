package me.arrhioui.billingservice.repository;

import me.arrhioui.billingservice.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByCustomerID(long customerID);
}
