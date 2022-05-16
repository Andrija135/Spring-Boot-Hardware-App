package hr.tvz.poljak.hardwareapp.review.service;

import hr.tvz.poljak.hardwareapp.review.model.Review;
import hr.tvz.poljak.hardwareapp.review.model.ReviewDTO;
import hr.tvz.poljak.hardwareapp.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<ReviewDTO> findAll() {
        return reviewRepository
                .findAll()
                .stream()
                .map(this::mapReviewToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReviewDTO> findByHardwareByCode(String code) {
        return reviewRepository
                .findAllByHardwareCode(code)
                .stream()
                .map(this::mapReviewToDTO)
                .collect(Collectors.toList());
    }

    private ReviewDTO mapReviewToDTO(final Review review) {
        return new ReviewDTO(
                review.getId(),
                review.getTitle(),
                review.getText(),
                review.getRating()
        );
    }
}
