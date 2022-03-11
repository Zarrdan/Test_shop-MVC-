package ru.pcs.example.javashop.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import ru.pcs.example.javashop.forms.ReviewForm;
import ru.pcs.example.javashop.models.Review;
import ru.pcs.example.javashop.repositories.ReviewRepository;
import java.util.List;

@Validated
@Component
public class ReviewServiceImpl implements ReviewsService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public Review addReview(ReviewForm form) {
        Review review = Review.builder()
                .name(form.getName())
                .review(form.getReview())
                .build();
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }

}
