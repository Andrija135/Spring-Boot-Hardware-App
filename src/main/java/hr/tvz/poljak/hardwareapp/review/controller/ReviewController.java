package hr.tvz.poljak.hardwareapp.review.controller;


import hr.tvz.poljak.hardwareapp.review.model.ReviewDTO;
import hr.tvz.poljak.hardwareapp.review.service.ReviewService;
import org.springframework.security.access.annotation.Secured;
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
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public List<ReviewDTO> getAllReviews() {
        return reviewService.findAll();
    }

    @GetMapping("{code}")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public List<ReviewDTO> getReviewsForHardware(@PathVariable String code) {
        return reviewService.findByHardwareCode(code);
    }

}
