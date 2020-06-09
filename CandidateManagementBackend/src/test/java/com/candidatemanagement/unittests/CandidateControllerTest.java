package com.candidatemanagement.unittests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

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

import com.candidatemanagement.controller.CandidateController;
import com.candidatemanagement.model.Candidate;
import com.candidatemanagement.service.CandidateService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CandidateControllerTest {

	@Autowired
	private CandidateController candidateController;
	
	@MockBean
	private CandidateService candidateService;
	
	@Test
	public void getAllCandidatesTest() {
		when(candidateService.getAllCandidates()).thenReturn(
				Stream.of(
					new Candidate("Harsh","harsh@gmail.com","DJSCE",1234567890,"SDE","Mumbai","C++ Java","2020-05-11"),
					new Candidate("Prihaan","prihaan@gmail.com","NSIT",1324567890,"SE","Chennai","Python Java","2020-05-13")
					).collect(Collectors.toList())
			);
		assertEquals(2,candidateController.getAllCandidates().size());
	}
	
	@Test
	public void getCandidateByIdTest() {
		when(candidateService.getCandidateById(1)).thenReturn(null);
		assertNull(candidateController.getCandidateById(1));
	}
	
	@Test
	public void addCandidateTest() {
		Candidate candidate = new Candidate("Harsh","harsh123@hotmail.com","DJSCE",1234567890,"SDE","Mumbai","C++ Java","2020-05-11");
		ResponseEntity<?> response = ResponseEntity.status(HttpStatus.CREATED).build();
		when(candidateService.addCandidate(candidate)).thenReturn(ResponseEntity.status(HttpStatus.CREATED).build());
		assertEquals(response,candidateController.addCandidate(candidate));
	}
	
	@Test
	public void updateCandidateTest() {
		Candidate candidate = new Candidate("Harsh","harsh123@hotmail.com","DJSCE",1234567890,"SDE","Mumbai","C++ Java","2020-05-11");
		when(candidateService.updateCandidate(candidate,1)).thenReturn(null);
		assertNull(candidateController.updateCandidate(candidate,1));
	}
	
	@Test
	public void deleteCandidateTest() {
		when(candidateService.deleteCandidate(1)).thenReturn(null);
		assertNull(candidateController.deleteCandidate(1));
	}
}
