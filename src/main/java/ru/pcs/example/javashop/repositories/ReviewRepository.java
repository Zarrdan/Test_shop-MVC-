package ru.pcs.example.javashop.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.example.javashop.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
