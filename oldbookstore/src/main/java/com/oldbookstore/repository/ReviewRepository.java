package com.oldbookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.oldbookstore.entity.Review;
@CrossOrigin("http://localhost:4200")
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
