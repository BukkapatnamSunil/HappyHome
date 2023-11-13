package com.tyss.happyhome.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.happyhome.Repository.HappyHomeReviewRepository;
import com.tyss.happyhome.entity.Review;

//@Repository
@RestController
public class ReviewDao {
	
	@Autowired
	private HappyHomeReviewRepository reviewRepository;
	
	//method to save review
	public Review saveReview(Review review)
	{
		return reviewRepository.save(review);
	}
	
	//method to get review based on id
	public Review getReviewById(int id)
	{
		Optional<Review> opt = reviewRepository.findById(id);
		if(opt.isPresent())
		{
			return opt.get();
		}
		return null;
	}
	
	//method to get list of reviews
	public List<Review> getAllReviews()
	{
		List<Review> list = reviewRepository.findAll();
		return list;
	}
	
	//method to update review
	public Review updateReview(Review review)
	{
		return reviewRepository.save(review);
	}
	
	//method to delete review based on id
	public String deleteReviewById(int id)
	{
		Optional<Review> opt = reviewRepository.findById(id);
		if(opt.isPresent())
		{
			Review rev = opt.get();
			reviewRepository.delete(rev);
			return "Review"+id+"deleted successfully";
		}
		return "No record found to delete";
	}
}
