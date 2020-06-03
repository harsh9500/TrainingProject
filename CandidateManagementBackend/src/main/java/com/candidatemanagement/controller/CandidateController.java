package com.candidatemanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.candidatemanagement.model.Candidate;
import com.candidatemanagement.service.CandidateService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CandidateController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CandidateService candidateService;
	
	@GetMapping("/candidates")
	public List<Candidate> getAllCandidates() {
		logger.info("Calling GET all candidates");
		return candidateService.getAllCandidates();
	}
	
	@GetMapping("/candidates/{id}")
	public ResponseEntity<?> getCandidateById (@PathVariable long id) {
		logger.info("Calling GET candidate by ID");
		return candidateService.getCandidateById(id);
	}
	
	@PostMapping("/candidates")
	public ResponseEntity<?> addCandidate(@RequestBody Candidate candidate) {
		logger.info("Calling POST candidate");
		return candidateService.addCandidate(candidate);
	}
	
	@PutMapping("/candidates/{id}")
	public ResponseEntity<?> updateCandidate(@RequestBody Candidate candidate, @PathVariable long id) {
		logger.info("Calling UPDATE candidate");
		return candidateService.updateCandidate(candidate,id);
	}
	
	@DeleteMapping("/candidates/{id}")
	public ResponseEntity<?> deleteCandidate(@PathVariable long id) {
		logger.info("Calling DELETE candidate");
		return candidateService.deleteCandidate(id);
	}
	
	
}
