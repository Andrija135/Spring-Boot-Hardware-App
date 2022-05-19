package hr.tvz.poljak.hardwareapp.review.controller;


import hr.tvz.poljak.hardwareapp.review.model.ReviewDTO;
import hr.tvz.poljak.hardwareapp.review.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reviews")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

    private final ReviewService reviewService;


    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping
    public List<ReviewDTO> getAllReviews() {
        return reviewService.findAll();
    }

    @GetMapping("{code}")
    public List<ReviewDTO> getReviewsForHardware(@PathVariable String code) {
        return reviewService.findByHardwareCode(code);
    }

}
