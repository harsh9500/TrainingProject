package com.candidatemanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candidatemanagement.model.Result;
import com.candidatemanagement.service.TrendsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TrendsController {

	@Autowired
	TrendsService trendsService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/trends/location")
	public List<Result> getLocationTrends() {
		logger.info("Calling GET location trends");
		return trendsService.getLocationTrends();
	}
	
	@GetMapping("/trends/institute")
	public List<Result> getInstituteTrends() {
		logger.info("Calling GET institute trends");
		return trendsService.getInstituteTrends();
	}
	
	@GetMapping("/trends/description")
	public List<Result> getDescriptionTrends() {
		logger.info("Calling GET description trends");
		return trendsService.getDescriptionTrends();
	}
}
