package com.candidatemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.candidatemanagement.dao.CandidateDao;
import com.candidatemanagement.model.Candidate;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	CandidateDao candidateDao;
	
	@Override
	public List<Candidate> getAllCandidates() {
		return candidateDao.getAllCandidates();
	}


	@Override
	public ResponseEntity<?> getCandidateById(long id) {
		Optional <Candidate> candidate = candidateDao.getCandidateById(id);
		if(candidate!=null) {
			return new ResponseEntity<Candidate>(candidate.get(),HttpStatus.OK);
		}
		return new ResponseEntity<String>("User not found",HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<String> addCandidate(Candidate candidate) {
		Optional <Candidate> lookupCandidate = candidateDao.getCandidateById(candidate.getId());
		if(lookupCandidate!=null) {
			return new ResponseEntity<String>("Duplicate Entry",HttpStatus.IM_USED);
		}
		candidateDao.addCandidate(candidate);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}


	@Override
	public ResponseEntity<?> updateCandidate(Candidate candidate, long id) {
		Optional <Candidate> lookupCandidate = candidateDao.getCandidateById(id);
		if(lookupCandidate==null) {
			return new ResponseEntity<String>("User does not exist",HttpStatus.NOT_FOUND);
		}
		candidateDao.updateCandidate(candidate,id);
		candidate.setId(id);
		return new ResponseEntity<Candidate>(candidate,HttpStatus.OK);
	}


	@Override
	public ResponseEntity<?> deleteCandidate(long id) {
		Optional <Candidate> lookupCandidate = candidateDao.getCandidateById(id);
		if(lookupCandidate==null) {
			return new ResponseEntity<String>("User does not exist",HttpStatus.NOT_FOUND);
		}
		candidateDao.deleteCandidate(id);
		return new ResponseEntity<Candidate>(HttpStatus.NO_CONTENT);
	}


}
