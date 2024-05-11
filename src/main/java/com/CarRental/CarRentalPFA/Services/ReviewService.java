package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DTO.ReviewDTO;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> getReviews();
    ReviewDTO addReview(ReviewDTO reviewDTO);

    ReviewDTO updateReview(ReviewDTO reviewDTO);

    ReviewDTO deleteReview(Long reviewId);


}
