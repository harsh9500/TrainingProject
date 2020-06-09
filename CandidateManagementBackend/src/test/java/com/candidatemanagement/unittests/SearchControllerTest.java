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

import com.candidatemanagement.controller.SearchController;
import com.candidatemanagement.model.Candidate;
import com.candidatemanagement.service.SearchService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SearchControllerTest {

	@Autowired
	private SearchController searchController;
	
	@MockBean
	private SearchService searchService;
	
	@Test
	public void getSearchResultsTest() {
		when(searchService.getSearchResults("institute", "djsce")).thenReturn(
				Stream.of(
					new Candidate("Harsh","harsh@gmail.com","DJSCE",1234567890,"SDE","Mumbai","C++ Java","2020-05-11"),
					new Candidate("Prihaan","prihaan@gmail.com","DJSCE",1324567890,"SE","Chennai","Python Java","2020-05-13")
					).collect(Collectors.toList())
			);
		assertEquals(2,searchController.getSearchResults("institute","djsce").size());
	}
	
	@Test
	public void getAllSearchResultsTest() {
		when(searchService.getSearchResults("institute","")).thenReturn(
				Stream.of(
					new Candidate("Harsh","harsh@gmail.com","DJSCE",1234567890,"SDE","Mumbai","C++ Java","2020-05-11"),
					new Candidate("Prihaan","prihaan@gmail.com","NSIT",1324567890,"SE","Chennai","Python Java","2020-05-13")
					).collect(Collectors.toList())
			);
		assertEquals(2,searchController.getAllSearchResults("institute").size());
	}
}
