package com.candidatemanagement.unittests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.candidatemanagement.dao.CandidateDao;
import com.candidatemanagement.model.Candidate;
import com.candidatemanagement.service.CandidateService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CandidateServiceImplTest {
	
	@Autowired
	private CandidateService candidateService;
	
	@MockBean
	private CandidateDao candidateDao;

	@Test
	public void getAllCandidatesTest() {
		when(candidateDao.getAllCandidates()).thenReturn(
				Stream.of(
					new Candidate("Harsh","harsh@gmail.com","DJSCE",1234567890,"SDE","Mumbai","C++ Java","2020-05-11"),
					new Candidate("Prihaan","prihaan@gmail.com","NSIT",1324567890,"SE","Chennai","Python Java","2020-05-13")
					).collect(Collectors.toList())
			);
		assertEquals(2,candidateService.getAllCandidates().size());
	}
	
	@Test
	public void addCandidateTest() {
		Candidate candidate = new Candidate("Harsh","harsh123@hotmail.com","DJSCE",1234567890,"SDE","Mumbai","C++ Java","2020-05-11");
		when(candidateDao.addCandidate(candidate)).thenReturn(true);
		ResponseEntity<String> response = ResponseEntity.status(HttpStatus.CREATED).build();
		assertEquals(response,candidateService.addCandidate(candidate));
	}
	
	@Test
	public void getCandidateByIdTest() {
		Candidate candidate = new Candidate();
		when(candidateDao.getCandidateById(1)).thenReturn(Optional.of(candidate));
		assertEquals(new ResponseEntity<Candidate>(candidate,HttpStatus.OK),candidateService.getCandidateById(1));
	}
	
	@Test
	public void updateCandidateTest() {
		Candidate candidate = new Candidate();
		when(candidateDao.getCandidateById(1)).thenReturn(Optional.of(candidate));
		when(candidateDao.updateCandidate(candidate, 1)).thenReturn(1);
		assertEquals(new ResponseEntity<Candidate>(candidate,HttpStatus.OK),candidateService.updateCandidate(candidate, 1));
	}
	
	@Test
	public void deleteCandidateTest() {
		Candidate candidate = new Candidate();
		when(candidateDao.getCandidateById(1)).thenReturn(Optional.of(candidate));
		when(candidateDao.deleteCandidate(1)).thenReturn(1);
		assertEquals(new ResponseEntity<Candidate>(HttpStatus.NO_CONTENT),candidateService.deleteCandidate(1));
	}
	
	@Test
	public void deleteCandidateWhichDoesNotExistTest() {
		assertEquals(new ResponseEntity<String>("Candidate does not exist",HttpStatus.NOT_FOUND),candidateService.deleteCandidate(-1));
	}
	
	@Test
	public void updateCandidateWhichDoesNotExistTest() {
		Candidate candidate = new Candidate();
		assertEquals(new ResponseEntity<String>("Candidate does not exist",HttpStatus.NOT_FOUND),candidateService.updateCandidate(candidate,-1));
	}
	
	@Test
	public void getCandidateWhichDoesNotExistByIdTest() {
		assertEquals(new ResponseEntity<String>("User not found",HttpStatus.NOT_FOUND),candidateService.getCandidateById(-1));
	}
	
	@Test
	public void addCandidateWithAlreadyExistingEmailTest() {
		Candidate candidate = new Candidate("Harsh","harsh123@hotmail.com","DJSCE",1234567890,"SDE","Mumbai","C++ Java","2020-05-11");
		when(candidateDao.getCandidateByEmail(candidate.getEmail())).thenReturn(Optional.of(candidate));
		assertEquals(new ResponseEntity<String>("Email ID already exists",HttpStatus.IM_USED),candidateService.addCandidate(candidate));
	}
	
	@Test
	public void addCandidateWithAlreadyExistingContactTest() {
		Candidate candidate = new Candidate();
		candidate.setContact(1234567890);
		candidate.setDescription("SDE");
		candidate.setEmail("harsh123@hotmail.com");
		candidate.setInstitute("DJSCE");
		candidate.setName("Harsh");
		candidate.setLocation("Mumbai");
		candidate.setFeedback("Good");
		candidate.setId(1);
		candidate.setJoiningDate("2020/06/09");
		candidate.setSkills("C++ Java Python");
		System.out.println(candidate);
		System.out.println(candidate.getId());
		System.out.println(candidate.getName());
		System.out.println(candidate.getDescription());
		System.out.println(candidate.getInstitute());
		System.out.println(candidate.getFeedback());
		System.out.println(candidate.getJoiningDate());
		System.out.println(candidate.getLocation());
		System.out.println(candidate.getSkills());
		when(candidateDao.getCandidateByContact(candidate.getContact())).thenReturn(Optional.of(candidate));
		assertEquals(new ResponseEntity<String>("Contact already exists",HttpStatus.IM_USED),candidateService.addCandidate(candidate));
	}
}