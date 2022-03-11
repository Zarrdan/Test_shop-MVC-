package ru.pcs.example.javashop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.example.javashop.models.Seller;


public interface SellerRepository extends JpaRepository<Seller, Integer> {
}

