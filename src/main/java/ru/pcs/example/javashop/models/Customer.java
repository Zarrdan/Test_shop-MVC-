package ru.pcs.example.javashop.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String first_Name;
    private String last_Name;
    private String phone;
    private String email;
    private String adress;
    @OneToMany(mappedBy = "customer")
    private List<Product> products;
}

