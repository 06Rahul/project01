/*package Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companeyId);
    void addReview(Long companeyId , Review review);

}*/


package Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companeyId);
    void addReview(Long companeyId, Review review);
    void deleteReview(Long reviewId);
    Review getReviewById(Long reviewId);
    void updateReview(Long reviewId, Review review);
}

