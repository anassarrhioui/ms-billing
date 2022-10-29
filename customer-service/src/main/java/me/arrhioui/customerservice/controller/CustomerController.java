package me.arrhioui.customerservice.controller;

import me.arrhioui.customerservice.dto.CustomerRequestDTO;
import me.arrhioui.customerservice.dto.CustomerResponseDTO;
import me.arrhioui.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerResponseDTO> customersList(){
        return customerService.getListCustomer();
    }

    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomerById(@PathVariable String id){
        if(id.matches("\\d*")){
            return customerService.getCustomer(Long.parseLong(id));
        }else {
            return null;
        }
    }

    @PostMapping
    public CustomerResponseDTO saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        return customerService.save(customerRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        if(id.matches("\\d*")){
            customerService.delete(Long.parseLong(id));
        }
    }
}
