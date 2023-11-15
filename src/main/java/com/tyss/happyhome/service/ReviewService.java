package com.tyss.happyhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tyss.happyhome.dao.ReviewDao;
import com.tyss.happyhome.dto.ResponseStructure;
import com.tyss.happyhome.entity.Review;
import com.tyss.happyhome.exception.IdDoesNotFoundException;
import com.tyss.happyhome.exception.Nullexception;

@Service
@Component
public class ReviewService {
	
	@Autowired
	private ReviewDao reviewDao;
	
	
	public ResponseEntity<ResponseStructure<Review>> saveReviewOfProperty(Review review,int id)
	{
		Review receivedReview = reviewDao.saveReviewOfProperty(review,id);
		if(receivedReview!=null) {
			ResponseStructure<Review> responseStructure = new ResponseStructure<Review>();
			responseStructure.setStatusCode(201);
			responseStructure.setMessage("Success");
			responseStructure.setData(receivedReview);
			
			return new ResponseEntity<ResponseStructure<Review>>(responseStructure, HttpStatus.CREATED);
		}
		else {
			throw new Nullexception();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Review>> saveReviewOfService(Review review,int id)
	{
		Review receivedReview = reviewDao.saveReviewOfService(review,id);
		if(receivedReview!=null) {
			ResponseStructure<Review> responseStructure = new ResponseStructure<Review>();
			responseStructure.setStatusCode(201);
			responseStructure.setMessage("Success");
			responseStructure.setData(receivedReview);
			
			return new ResponseEntity<ResponseStructure<Review>>(responseStructure, HttpStatus.CREATED);
		}
		else {
			throw new Nullexception();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Review>> getReviewById(int id)
	{
		Review review = reviewDao.getReviewById(id);
		if(review != null)
		{
			ResponseStructure<Review> responseStructure = new ResponseStructure<Review>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(review);
			
			return new ResponseEntity<ResponseStructure<Review>>(responseStructure, HttpStatus.CREATED);
		}
		else
		{
			throw new IdDoesNotFoundException("ID: "+id+", not present in DB");
		}
	}
	
	
	public ResponseEntity<ResponseStructure<List<Review>>> getAllReviews() {
		
        List<Review> reviews = reviewDao.getAllReviews();

        ResponseStructure<List<Review>> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Reviews retrieved successfully");
        responseStructure.setData(reviews);

        return new ResponseEntity<ResponseStructure<List<Review>>>(responseStructure, HttpStatus.OK);
    }
	
	public ResponseEntity<ResponseStructure<Review>> updateReview(Review review) {
       
        Review updated = reviewDao.updateReview(review);

        ResponseStructure<Review> responseStructure = new ResponseStructure<Review>();
        
        if (updated != null) {
            responseStructure.setStatusCode(HttpStatus.OK.value());
            responseStructure.setMessage("Review updated successfully");
            responseStructure.setData(updated);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        } else {
            responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessage("Failed to update the review");
            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }
    }
	
	public ResponseEntity<ResponseStructure<String>> deleteReviewById(int id) {
 
        String deleted = reviewDao.deleteReviewById(id);
        
        ResponseStructure<String> responseStructure = new ResponseStructure<>();

        if (deleted!=null) {
            responseStructure.setStatusCode(HttpStatus.OK.value());
            responseStructure.setMessage("Review deleted successfully");
            responseStructure.setData("Review with ID " + id + " has been deleted");
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        } else {
            responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessage("Failed to delete the review");
            responseStructure.setData("Review with ID " + id + " not found");
            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }
    }

}
