package ru.pcs.example.javashop.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SellerForm {
    private String entity;
    private String phone;
    private String email;
    private String adress;
}

