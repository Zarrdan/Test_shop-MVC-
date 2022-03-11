package ru.pcs.example.javashop.forms;


import lombok.*;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerForm {
    private String first_Name;
    private String last_Name;
    private String phone;
    private String email;
    private String adress;
}


