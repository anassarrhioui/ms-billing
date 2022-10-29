package me.arrhioui.customerservice;

import me.arrhioui.customerservice.dto.CustomerRequestDTO;
import me.arrhioui.customerservice.entity.Customer;
import me.arrhioui.customerservice.service.CustomerService;
import me.arrhioui.customerservice.service.CustomerServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerService customerService){
        return args -> {
            customerService.save(new CustomerRequestDTO(null, "Anass", "anassa@gmail.com"));
            customerService.save(new CustomerRequestDTO(null, "amine", "amine@gmail.com"));
            customerService.getListCustomer().forEach(System.out::println);
        };
    }

}
