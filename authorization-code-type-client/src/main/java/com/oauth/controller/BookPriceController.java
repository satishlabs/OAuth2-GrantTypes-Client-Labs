package com.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oauth.entity.BookPriceInfo;

@RestController
@RequestMapping("/myapi")
public class BookPriceController {
	
	@GetMapping("/bookPrice/{bookId}")
	public BookPriceInfo getBookPriceById(@PathVariable Integer bookId) {
		System.out.println("BookPriceController -- getBookPriceById()");
		BookPriceInfo bInfo = new BookPriceInfo(bookId, 20.0, 540.0);
		return bInfo;
	}
}
