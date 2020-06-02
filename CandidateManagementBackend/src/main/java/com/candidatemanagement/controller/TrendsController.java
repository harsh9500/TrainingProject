package com.candidatemanagement.controller;

import java.util.List;

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
	
	@GetMapping("/trends/location")
	public List<Result> getLocationTrends() {
		return trendsService.getLocationTrends();
	}
	
	@GetMapping("/trends/institute")
	public List<Result> getInstituteTrends() {
		return trendsService.getInstituteTrends();
	}
	
	@GetMapping("/trends/description")
	public List<Result> getDescriptionTrends() {
		return trendsService.getDescriptionTrends();
	}
}
