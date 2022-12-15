package edu.miu.springsecurity1.repository;

import edu.miu.springsecurity1.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Integer> {
    Iterable<Review> findReviewsByProductId(int productId);
}
