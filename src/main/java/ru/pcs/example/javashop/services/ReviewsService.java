package ru.pcs.example.javashop.services;

import ru.pcs.example.javashop.forms.ReviewForm;
import ru.pcs.example.javashop.models.Review;

import java.util.List;

public interface ReviewsService {

    Review addReview(ReviewForm form);

    List<Review> getAllReview();

}
