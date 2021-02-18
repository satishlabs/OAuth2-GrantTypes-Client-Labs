package com.oauth.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oauth.entity.UserRatingInfo;

@RestController
@RequestMapping("/myapi")
public class UserRatingController {
	
	@GetMapping("/userRating/{userId}")
	public List<UserRatingInfo> getBookPriceById(@PathVariable String userId) {
		System.out.println("BookPriceController -- getBookPriceById()");
		List<UserRatingInfo> myList = new ArrayList<UserRatingInfo>();
		UserRatingInfo urInfo = new UserRatingInfo(userId, 109, 5, "Good Book");
		myList.add(urInfo);
		myList.add(urInfo);
		myList.add(urInfo);
		return myList;
	}
}
