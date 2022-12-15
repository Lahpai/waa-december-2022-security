package edu.miu.springsecurity1.controller;

import edu.miu.springsecurity1.dto.ReviewDto;
import edu.miu.springsecurity1.entity.Review;
import edu.miu.springsecurity1.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public void save(@RequestBody Review review) {
        reviewService.save(review);
    }

    @GetMapping
    public List<ReviewDto> findAll() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewDto findById(@PathVariable int id) {
        return reviewService.findById(id);
    }

    @PutMapping("/{id}")
    public void save(@PathVariable int id, @RequestBody Review review) {
        if (id > 0)
            review.setId(id);
        reviewService.save(review);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        reviewService.deleteById(id);
    }

    @GetMapping("byProductId/{productId}")
    List<ReviewDto> findReviewsByProductId(@PathVariable int productId){
        return reviewService.findReviewsByProductId(productId);
    }
}
