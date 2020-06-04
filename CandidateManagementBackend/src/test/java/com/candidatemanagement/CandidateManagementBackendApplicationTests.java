package com.candidatemanagement;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.candidatemanagement.dao.CandidateDao;
import com.candidatemanagement.dao.SearchDao;
import com.candidatemanagement.dao.TrendsDao;
import com.candidatemanagement.model.Candidate;
import com.candidatemanagement.model.Result;
import com.candidatemanagement.service.CandidateService;
import com.candidatemanagement.service.SearchService;
import com.candidatemanagement.service.TrendsService;

import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
class CandidateManagementBackendApplicationTests {

	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private SearchService searchService;
	
	@Autowired
	private TrendsService trendsService;
	
	@MockBean
	private CandidateDao candidateDao;
	
	@MockBean
	private SearchDao searchDao;
	
	@MockBean
	private TrendsDao trendsDao;
	
	@Test
	void contextLoads() {
	}
	
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
	public void getSearchByLocationResultsTest() {
		when(searchDao.getSearchResults("location", "Mumbai")).thenReturn(
				Stream.of(
						new Candidate("Harsh","harsh@gmail.com","DJSCE",1234567890,"SDE","Mumbai","C++ Java","2020-05-11"),
						new Candidate("Prihaan","prihaan@gmail.com","NSIT",1324567890,"SE","Mumbai","Python Java","2020-05-13")
					).collect(Collectors.toList()));
		assertEquals(2,searchService.getSearchResults("location", "Mumbai").size());
	}
	
	@Test
	public void getSearchByInstituteResultsTest() {
		when(searchDao.getSearchResults("institute", "DJSCE")).thenReturn(
				Stream.of(
						new Candidate("Harsh","harsh@gmail.com","DJSCE",1234567890,"SDE","Mumbai","C++ Java","2020-05-11"),
						new Candidate("Prihaan","prihaan@gmail.com","DJSCE",1324567890,"SE","Mumbai","Python Java","2020-05-13")
					).collect(Collectors.toList()));
		assertEquals(2,searchService.getSearchResults("institute", "DJSCE").size());
	}
	
	@Test
	public void getSearchBySkillsResultsTest() {
		when(searchDao.getSearchResults("skills", "Java")).thenReturn(
				Stream.of(
						new Candidate("Harsh","harsh@gmail.com","DJSCE",1234567890,"SDE","Mumbai","C++ Java","2020-05-11"),
						new Candidate("Prihaan","prihaan@gmail.com","DJSCE",1324567890,"SE","Mumbai","Python Java","2020-05-13")
					).collect(Collectors.toList()));
		assertEquals(2,searchService.getSearchResults("skills", "Java").size());
	}
	
	@Test
	public void getLocationTrendsTest() {
		when(trendsDao.getLocationTrends()).thenReturn(
				Stream.of(
						new Result("Mumbai","2"),
						new Result("Bengaluru","2")
					).collect(Collectors.toList()));
		assertEquals(2,trendsService.getLocationTrends().size());
	}
	
	@Test
	public void getInstituteTrendsTest() {
		when(trendsDao.getInstituteTrends()).thenReturn(
				Stream.of(
						new Result("DJSCE","2"),
						new Result("IIT KGP","2")
					).collect(Collectors.toList()));
		assertEquals(2,trendsService.getInstituteTrends().size());
	}
	
	@Test
	public void getDescriptionTrendsTest() {
		when(trendsDao.getDescriptionTrends()).thenReturn(
				Stream.of(
						new Result("SE","2"),
						new Result("SDE","2")
					).collect(Collectors.toList()));
		assertEquals(2,trendsService.getDescriptionTrends().size());
	}

}