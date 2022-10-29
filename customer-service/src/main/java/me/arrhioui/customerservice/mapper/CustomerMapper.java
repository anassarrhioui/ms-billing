package me.arrhioui.customerservice.mapper;

import me.arrhioui.customerservice.dto.CustomerRequestDTO;
import me.arrhioui.customerservice.dto.CustomerResponseDTO;
import me.arrhioui.customerservice.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);
}
