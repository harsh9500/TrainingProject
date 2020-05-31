package com.candidatemanagement.controller;

import java.util.List;

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
import com.candidatemanagement.model.Skill;
import com.candidatemanagement.service.CandidateService;
import com.candidatemanagement.service.CandidateServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CandidateController {

	@Autowired
	CandidateService candidateService = new CandidateServiceImpl();
	
	@GetMapping("/candidates")
	public List<Candidate> getAllCandidates() {
		return candidateService.getAllCandidates();
	}
	
	@GetMapping("/candidates/{id}")
	public ResponseEntity<?> getCandidateById (@PathVariable long id) {
		return candidateService.getCandidateById(id);
	}
	
	@PostMapping("/candidates")
	public ResponseEntity<?> addCandidate(@RequestBody Candidate candidate) {
		return candidateService.addCandidate(candidate);
	}
	
	@PutMapping("/candidates/{id}")
	public ResponseEntity<?> updateCandidate(@RequestBody Candidate candidate, @PathVariable long id) {
		return candidateService.updateCandidate(candidate,id);
	}
	
	@DeleteMapping("/candidates/{id}")
	public ResponseEntity<?> deleteCandidate(@PathVariable long id) {
		return candidateService.deleteCandidate(id);
	}
	
	@GetMapping("/skills")
	public List<Skill> getAllSkills() {
		return candidateService.getAllSkills();
	}
	
	
}
