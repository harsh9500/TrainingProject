package com.candidatemanagement.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<Candidate> getAllCandidates() {
		logger.info("Returning list of all candidates");
		return candidateDao.getAllCandidates();
	}


	@Override
	public ResponseEntity<?> getCandidateById(long id) {
		Optional <Candidate> candidate = candidateDao.getCandidateById(id);
		if(candidate.isPresent()) {
			logger.info("Returning candidate with ID "+id);
			return new ResponseEntity<Candidate>(candidate.get(),HttpStatus.OK);
		}
		logger.error("Candidate with ID "+id+" does not exist");
		return new ResponseEntity<String>("User not found",HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<String> addCandidate(Candidate candidate) {
		Optional <Candidate> lookupCandidateByEmail = candidateDao.getCandidateByEmail(candidate.getEmail());
		if(lookupCandidateByEmail!=null && lookupCandidateByEmail.isPresent()) {
			logger.error("Candidate with Email "+candidate.getEmail()+" already exists");
			return new ResponseEntity<String>("Email ID already exists",HttpStatus.IM_USED);
		}
		Optional <Candidate> lookupCandidateByContact = candidateDao.getCandidateByContact(candidate.getContact());
		if(lookupCandidateByContact!=null && lookupCandidateByContact.isPresent()) {
			logger.error("Candidate with Contact "+candidate.getContact()+" already exists");
			return new ResponseEntity<String>("Contact already exists",HttpStatus.IM_USED);
		}
		candidateDao.addCandidate(candidate);
		logger.info("Adding new candidate");
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}


	@Override
	public ResponseEntity<?> updateCandidate(Candidate candidate, long id) {
		Optional <Candidate> lookupCandidate = candidateDao.getCandidateById(id);
		if(!lookupCandidate.isPresent()) {
			logger.error("Candidate with ID "+id+" does not exist");
			return new ResponseEntity<String>("Candidate does not exist",HttpStatus.NOT_FOUND);
		}
		logger.info("Updating candidate with ID "+id);
		candidateDao.updateCandidate(candidate,id);
		candidate.setId(id);
		return new ResponseEntity<Candidate>(candidate,HttpStatus.OK);
	}


	@Override
	public ResponseEntity<?> deleteCandidate(long id) {
		Optional <Candidate> lookupCandidate = candidateDao.getCandidateById(id);
		if(!lookupCandidate.isPresent()) {
			logger.error("Candidate with ID "+id+" does not exist");
			return new ResponseEntity<String>("Candidate does not exist",HttpStatus.NOT_FOUND);
		}
		logger.warn("Deleting candidate with ID "+id);
		candidateDao.deleteCandidate(id);
		return new ResponseEntity<Candidate>(HttpStatus.NO_CONTENT);
	}


}
