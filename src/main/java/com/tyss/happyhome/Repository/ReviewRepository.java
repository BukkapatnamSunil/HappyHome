package com.tyss.happyhome.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.happyhome.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{

}
