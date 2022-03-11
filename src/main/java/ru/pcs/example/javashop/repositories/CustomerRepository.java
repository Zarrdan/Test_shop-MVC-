package ru.pcs.example.javashop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.example.javashop.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

