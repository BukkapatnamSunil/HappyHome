package com.tyss.happyhome.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.happyhome.Repository.HappyHomeReviewRepository;
import com.tyss.happyhome.entity.Property;
import com.tyss.happyhome.entity.Review;
import com.tyss.happyhome.entity.Service;

//@Repository
@RestController
public class ReviewDao {

	@Autowired
	private HappyHomeReviewRepository reviewRepository;

	@Autowired
	private PropertyDao propertyDao;
	@Autowired
	private ServiceDao serviceDao;

	// method to save review of property
	public Review saveReviewOfProperty(Review review, int id) {
		Property property = propertyDao.findByPropertyId(id);
		if (property != null) {
			List<Review> reviews=property.getList_reviews();
			reviews.add(review);
			property.setList_reviews(reviews);
			propertyDao.updateProperty(property);
			review.setProperty(property);
			return reviewRepository.save(review);
		}
		return null;
	}
	
	//save review of Service
	public Review saveReviewOfService(Review review, int id) {
		Service service = serviceDao.findByServiceId(id);
		if (service != null) {
			List<Review> reviews=service.getList_review();
			reviews.add(review);
			Review review1=reviewRepository.save(review);
			service.setList_review(reviews);
			serviceDao.updateService(service);
			return review1;
		}
		return null;
	}

	// method to get review based on id
	public Review getReviewById(int id) {
		Optional<Review> opt = reviewRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	// method to get list of reviews
	public List<Review> getAllReviews() {
		List<Review> list = reviewRepository.findAll();
		return list;
	}

	// method to update review
	public Review updateReview(Review review) {
		return reviewRepository.save(review);
	}

	// method to delete review based on id
//	public String deleteReviewById(int id) {
//		Optional<Review> opt = reviewRepository.findById(id);
//		if (opt.isPresent()) {
//			Review rev = opt.get();
//			reviewRepository.delete(rev);
//			return "Review" + id + "deleted successfully";
//		}
//		return "No record found to delete";
//	}
	
	// method to delete review based on id
		public String deleteReviewById(int id) {
			Optional<Review> opt = reviewRepository.findById(id);
			if (opt.isPresent()) {
				Review rev = opt.get();
//				List<Service> services=rev.getList_services();
//				if(!services.isEmpty()) {
//					for(Service service:services) {
//						service.setList_review(null);
//						serviceDao.updateService(service);
//					}
//				}
				reviewRepository.delete(rev);
				return "Review" + id + "deleted successfully";
			}
			return "No record found to delete";
		}
}
