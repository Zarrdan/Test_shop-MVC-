package ru.pcs.example.javashop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.pcs.example.javashop.models.Review;
import ru.pcs.example.javashop.services.ReviewsService;

import java.util.List;

@Controller
public class MainsController {

    private ReviewsService reviewsService;

    @Autowired
    public void ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    public MainsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping("/main")
    public String getAllReviews(Model model) {
        List<Review> reviewlist = reviewsService.getAllReview();
        model.addAttribute("main", reviewlist);
        return "main";
    }
}

