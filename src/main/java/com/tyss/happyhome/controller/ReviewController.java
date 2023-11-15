package com.tyss.happyhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.happyhome.dto.ResponseStructure;
import com.tyss.happyhome.entity.Review;
import com.tyss.happyhome.service.ReviewService;

@RestController
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	

	@PostMapping("/propertyreviews/{id}")
	public ResponseEntity<ResponseStructure<Review>> saveReviewOfProperty(@PathVariable(value = "id") int id,@RequestBody Review review)
	{
		return reviewService.saveReviewOfProperty(review,id);
	}
	
	
	@PostMapping("/servicereviews/{id}")
	public ResponseEntity<ResponseStructure<Review>> saveReviewOfService(@PathVariable(value = "id") int id,@RequestBody Review review)
	{
		return reviewService.saveReviewOfService(review,id);
	}
	
	@GetMapping("/reviewsId/{id}")
	public ResponseEntity<ResponseStructure<Review>> getReview(@PathVariable int id)
	{
		return reviewService.getReviewById(id);
	}
	
	@GetMapping("/getAllreviews")
	public ResponseEntity<ResponseStructure<List<Review>>> getAllReview()
	{
		return reviewService.getAllReviews();
	}
	
	@PutMapping("/reviewUpdate")
	public ResponseEntity<ResponseStructure<Review>> updateReview(@RequestBody Review review)
	{
		return reviewService.updateReview(review);
	}
	
	@DeleteMapping("/deleteReview/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteReviewById(@PathVariable int id)
	{
		return reviewService.deleteReviewById(id);
	}
}
