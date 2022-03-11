package ru.pcs.example.javashop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.pcs.example.javashop.JavashopApplicationTests;
import ru.pcs.example.javashop.forms.ReviewForm;
import ru.pcs.example.javashop.models.Review;
import ru.pcs.example.javashop.services.ReviewServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReviewServiceImplTest extends JavashopApplicationTests {


    @Autowired
    private ReviewServiceImpl reviewService;
    ReviewForm reviewForm = ReviewForm.builder()
            .name("Iphone13")
            .review("Хороший товар, рекомендую")
            .build();

    @Test
    void testgetAllReview() {
        List<Review> reviews = reviewService.getAllReview();
        assertNotNull(reviews);
    }

    @Test
    void testAddReview() {
        Review createReview = reviewService.addReview(reviewForm);
        assertNotNull(createReview.getId());
        assertEquals(createReview.getName(), reviewForm.getName());
        assertEquals(createReview.getReview(), reviewForm.getReview());
    }
}
