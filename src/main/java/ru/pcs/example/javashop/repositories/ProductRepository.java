package ru.pcs.example.javashop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.example.javashop.models.Product;


import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByCustomer_Id(Integer customerId);

    List<Product> findAllByCustomerIsNull();

    List<Product> findAllBySeller_Id(Integer sellerId);

    List<Product> findAllBySellerIsNull();
}

