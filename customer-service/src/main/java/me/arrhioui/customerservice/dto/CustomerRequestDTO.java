package me.arrhioui.customerservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerRequestDTO {
    private Long id;
    private String name;
    private String email;
}
