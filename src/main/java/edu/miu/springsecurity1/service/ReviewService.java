package edu.miu.springsecurity1.service;

import edu.miu.springsecurity1.dto.ReviewDto;
import edu.miu.springsecurity1.entity.Review;

import java.util.List;

public interface ReviewService {
    void save(Review review);
    List<ReviewDto> findAll();
    ReviewDto findById(int id);
    void deleteById(int id);
    List<ReviewDto> findReviewsByProductId(int productId);
}