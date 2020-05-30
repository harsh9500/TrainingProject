package com.candidatemanagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.candidatemanagement.model.Candidate;

public interface CandidateService {

	public List<Candidate> getAllCandidates();
	public ResponseEntity<?> getCandidateById(long id);
	public ResponseEntity<?> addCandidate(Candidate candidate);
	public ResponseEntity<?> updateCandidate(Candidate candidate, long id);
	public ResponseEntity<?> deleteCandidate(long id);
}
