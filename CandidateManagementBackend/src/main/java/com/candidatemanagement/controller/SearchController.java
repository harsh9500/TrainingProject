package com.candidatemanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.candidatemanagement.model.Candidate;
import com.candidatemanagement.service.SearchService;
import com.candidatemanagement.service.SearchServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SearchController {

	@Autowired
	SearchService searchService = new SearchServiceImpl();
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/search/{criterion}/{term}")
	public List<Candidate> getSearchResults(@PathVariable String criterion, @PathVariable String term) {
		logger.info("Calling GET search results with criterion "+criterion+" and term "+term);
		return searchService.getSearchResults(criterion,term);
		
	}
	
	@GetMapping("/search/{criterion}")
	public List<Candidate> getAllSearchResults(@PathVariable String criterion) {
		logger.info("Calling GET search results with criterion "+criterion);
		return searchService.getSearchResults(criterion,"");
		
	}
}
