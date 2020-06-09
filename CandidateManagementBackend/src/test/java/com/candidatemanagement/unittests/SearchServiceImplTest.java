package com.candidatemanagement.unittests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.candidatemanagement.dao.SearchDao;
import com.candidatemanagement.model.Candidate;
import com.candidatemanagement.service.SearchService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SearchServiceImplTest {

	@Autowired
	private SearchService searchService;
	
	@MockBean
	private SearchDao searchDao;
	
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
}
