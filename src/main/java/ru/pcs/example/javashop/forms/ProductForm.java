package ru.pcs.example.javashop.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductForm {
    private String name;
    private Integer cost;
    private Integer amount;
}

