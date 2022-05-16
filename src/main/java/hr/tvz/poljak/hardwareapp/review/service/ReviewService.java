package hr.tvz.poljak.hardwareapp.review.service;

import hr.tvz.poljak.hardwareapp.review.model.ReviewDTO;

import java.util.List;

public interface ReviewService {

    List<ReviewDTO> findAll();

    List<ReviewDTO> findByHardwareByCode(String code);
}
