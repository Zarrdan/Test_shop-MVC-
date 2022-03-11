package ru.pcs.example.javashop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.pcs.example.javashop.forms.ReviewForm;
import ru.pcs.example.javashop.models.Review;
import ru.pcs.example.javashop.services.ReviewsService;

import java.util.List;

@Controller
public class ReviewsController {

    private final ReviewsService reviewsService;

    @Autowired
    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping("/reviews")
    public String getAllReviews(Model model) {
        List<Review> reviewlist = reviewsService.getAllReview();
        model.addAttribute("reviews", reviewlist);
        return "reviews";
    }

    @PostMapping("/reviews")
    public String addReviews(ReviewForm form) {
        reviewsService.addReview(form);
        return "redirect:/reviews";
    }
}
