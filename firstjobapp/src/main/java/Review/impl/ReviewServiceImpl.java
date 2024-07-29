/*package Review.impl;

import Review.Review;
import Review.ReviewRepo;
import Review.ReviewService;
import com.Rahul.firstjobapp.companey.CompaneyEntity;
import com.Rahul.firstjobapp.companey.CompaneyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    public ReviewServiceImpl(ReviewRepo reviewRepo,CompaneyService companeyService) {
        this.reviewRepo = reviewRepo;
        this.companeyService = companeyService;
    }

    private ReviewRepo reviewRepo;
    private  final CompaneyService companeyService;


    @Override
    public List<Review> getAllReviews(Long companeyId) {
        List<Review> reviews =reviewRepo.findByCompaneyId(companeyId);
        return reviews;
    }

    @Override
    public void addReview(Long companeyId, Review review) {
        CompaneyEntity companeyEntity = companeyService.getcompaneybyid(companeyId);
        if (companeyEntity != null) {
            review.setCompanyEntity(companeyEntity);
            reviewRepo.save(review);  // Save the review to the repository
        }
    }
}*/


package Review.impl;

import Review.Review;
import Review.ReviewRepository;
import Review.ReviewService;
import com.Rahul.firstjobapp.companey.CompaneyEntity;
import com.Rahul.firstjobapp.companey.CompaneyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompaneyService companeyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompaneyService companeyService) {
        this.reviewRepository = reviewRepository;
        this.companeyService = companeyService;
    }

    @Override
    public List<Review> getAllReviews(Long companeyId) {
        return reviewRepository.findByCompaneyId(companeyId);
    }
    @Override
    public void addReview(Long companeyId, Review review) {
        CompaneyEntity companeyEntity = companeyService.getcompaneybyid(companeyId);
        if (companeyEntity != null) {
            //review.setCompaneyEntity(companeyEntity);  // Correct method call to set the company entity
            reviewRepository.save(review);
        }
    }


    @Override
    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public Review getReviewById(Long reviewId) {
        Optional<Review> review = reviewRepository.findById(reviewId);
        return review.orElse(null);
    }

    @Override
    public void updateReview(Long reviewId, Review review) {
        Optional<Review> existingReview = reviewRepository.findById(reviewId);
        if (existingReview.isPresent()) {
            Review reviewToUpdate = existingReview.get();
            reviewToUpdate.setTitle(review.getTitle());
            reviewToUpdate.setDescription(review.getDescription());
            reviewToUpdate.setRating(review.getRating());
            reviewRepository.save(reviewToUpdate);
        }
    }
}


