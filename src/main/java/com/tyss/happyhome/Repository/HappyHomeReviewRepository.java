package com.tyss.happyhome.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.tyss.happyhome.entity.Review;
@Component
public interface HappyHomeReviewRepository  extends JpaRepository<Review, Integer>{

}
