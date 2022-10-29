package me.arrhioui.customerservice.service;

import me.arrhioui.customerservice.dto.CustomerRequestDTO;
import me.arrhioui.customerservice.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(long id);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    void delete(long id);
    List<CustomerResponseDTO> getListCustomer();
}
