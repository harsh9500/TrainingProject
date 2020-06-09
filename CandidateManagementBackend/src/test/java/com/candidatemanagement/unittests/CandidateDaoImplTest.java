package com.candidatemanagement.unittests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.candidatemanagement.dao.CandidateDao;
import com.candidatemanagement.model.Candidate;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
class CandidateDaoImplTest {
	
	@Autowired
	private CandidateDao candidateDao;
	
	@Test
	public void getAllCandidatesTest() {
		List<Candidate> candidates = candidateDao.getAllCandidates();
		assertNotNull(candidates);
	}
	
	@Test
	public void addCandidateTest() {
		Candidate candidate = new Candidate("Harsh","harsh@gmail.com","DJSCE",1234567890,"SDE","Mumbai","C++ Java","2020-05-11");
		assertFalse(candidateDao.addCandidate(candidate));
	}
	
	@Test
	public void addCandidateWithNullFieldTest() {
		Candidate candidate = new Candidate("Harsh","","DJSCE",1234567890,"SDE","Mumbai","C++ Java","2020-05-11");
		candidate.setEmail(null);
		assertTrue(candidateDao.addCandidate(candidate));
	}
	
	@Test
	public void getCandidateByIdWhichIsPresentTest() {
		Optional<Candidate> candidate = candidateDao.getCandidateById(5);
		assertNotNull(candidate);
	}
	
	@Test
	public void getCandidateByIdWhichIsNotPresentTest() {
		Optional<Candidate> candidate = candidateDao.getCandidateById(0);
		assertNull(candidate);
	}
	
	@Test
	public void updateCandidateTest() {
		Candidate candidate = new Candidate("Harsh","harsh@gmail.com","DJSCE",1234567890,"SDE","Mumbai","C++ Java","2020-05-11");
		assertEquals(1,candidateDao.updateCandidate(candidate,5));
	}
	
	@Test
	public void updateNonExistingCandidateTest() {
		Candidate candidate = new Candidate("Harsh","harsh@gmail.com","DJSCE",1234567890,"SDE","Mumbai","C++ Java","2020-05-11");
		assertEquals(0,candidateDao.updateCandidate(candidate,0));
	}
	
	@Test
	public void deleteCandidateTest() {
		assertEquals(1,candidateDao.deleteCandidate(5));
	}
	
	@Test
	public void deleteNonExistingCandidateTest() {		
		assertEquals(0,candidateDao.deleteCandidate(0));
	}
	
	@Test
	public void getCandidateByEmailWhichIsPresentTest() {
		Optional<Candidate> candidate = candidateDao.getCandidateByEmail("farhan@gmail.com");
		assertNotNull(candidate);
	}
	
	@Test
	public void getCandidateByEmailWhichIsNotPresentTest() {
		Optional<Candidate> candidate = candidateDao.getCandidateByEmail("harsh123@hotmail.com");
		assertNull(candidate);
	}
	
	@Test
	public void getCandidateByContactWhichIsPresentTest() {
		Optional<Candidate> candidate = candidateDao.getCandidateByContact(9654120378L);
		assertNotNull(candidate);
	}
	
	@Test
	public void getCandidateByContactWhichIsNotPresentTest() {
		Optional<Candidate> candidate = candidateDao.getCandidateByContact(1234567890);
		assertNull(candidate);
	}
	
}
