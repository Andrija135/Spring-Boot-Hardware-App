package hr.tvz.poljak.hardwareapp.review.repository;

import hr.tvz.poljak.hardwareapp.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    List<Review> findAllByHardwareCode(String code);
}
