package com.oauth.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpClientErrorException;

import com.oauth.entity.BookPriceInfo;
import com.oauth.entity.UserRatingInfo;

@Controller
public class BookStoreWebController {
	
	@Autowired
	private OAuth2RestTemplate restTemplate;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/callback")
	public String callback() {
		return "forward:/mybookPriceInfo";
	}
	
	@GetMapping("/mybookPriceInfo")
	public String getBookPriceInfo(HttpSession session) {
		System.out.println("BookStoreWebController -- getBookPriceInfo()");

		String endpoint = "http://localhost:12345/myapi/bookPrice/105"; 
		try {
			System.out.println("Before BookPriceInfo");
			OAuth2AccessToken mytoken1 = restTemplate.getAccessToken();
			System.out.println(mytoken1.getValue());
			System.out.println(mytoken1.getTokenType());
			System.out.println(mytoken1.getExpiresIn());
			System.out.println(mytoken1.getScope());
			System.out.println(mytoken1.getRefreshToken());
			
			BookPriceInfo bInfo = restTemplate.getForObject(endpoint, BookPriceInfo.class);
			
			System.out.println("After BookPriceInfo");
			OAuth2AccessToken mytoken2 = restTemplate.getAccessToken();
			System.out.println(mytoken2.getValue());
			System.out.println(mytoken2.getTokenType());
			System.out.println(mytoken2.getExpiresIn());
			System.out.println(mytoken2.getScope());
			System.out.println(mytoken2.getRefreshToken());
			
			session.setAttribute("mybookPriceInfo", bInfo);
		}catch (HttpClientErrorException e) {
			throw new RuntimeException("Some problem in connecting BookPriceMS");
		}
		return "bookInfo";
	}
	
	@GetMapping("/mybookRatingInfo")
	public String getRatingInfp(HttpSession session) {
		System.out.println("BookStoreWebController -- getRatingInfp()");
		
		String endpoint = "http://localhost:12345/myapi/userRating/U-999"; 
		try {
			System.out.println("Before UserRatingInfo");
			OAuth2AccessToken mytoken1 = restTemplate.getAccessToken();
			System.out.println(mytoken1.getValue());
			System.out.println(mytoken1.getTokenType());
			System.out.println(mytoken1.getExpiresIn());
			System.out.println(mytoken1.getScope());
			System.out.println(mytoken1.getRefreshToken());
			
			List<UserRatingInfo> myList = restTemplate.getForObject(endpoint, List.class);
			
			System.out.println("After UserRatingInfo");
			OAuth2AccessToken mytoken2 = restTemplate.getAccessToken();
			System.out.println(mytoken2.getValue());
			System.out.println(mytoken2.getTokenType());
			System.out.println(mytoken2.getExpiresIn());
			System.out.println(mytoken2.getScope());
			System.out.println(mytoken2.getRefreshToken());
			
			session.setAttribute("myRatingList", myList);
		}catch (HttpClientErrorException e) {
			throw new RuntimeException("Some Problem in Connecting UserRatingMS");
		}
		return "ratingInfo";
	}
}
