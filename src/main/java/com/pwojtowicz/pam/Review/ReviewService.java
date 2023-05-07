package com.pwojtowicz.pam.Review;

import com.pwojtowicz.pam.Room.Room;
import com.pwojtowicz.pam.User.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {
        return this.reviewRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Review not found -> id: " + id));
    }

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review review) {
        Review existingReview = reviewRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Review not found -> id: " + id));

        existingReview.setText(review.getText());
        existingReview.setValue(review.getValue());
        existingReview.setUser(review.getUser());
        existingReview.setRoom(review.getRoom());

        return reviewRepository.save(existingReview);
    }

    public void deleteReview(Long id) {
        reviewRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Review not found -> id: " + id));
        reviewRepository.deleteById(id);
    }

    public List<Review> getAllReviewsForRoom(Room room) {
        return reviewRepository.findByRoom(room);
    }

    public List<Review> getAllReviewsByUser(User user) {
        return reviewRepository.findByUser(user);
    }
}