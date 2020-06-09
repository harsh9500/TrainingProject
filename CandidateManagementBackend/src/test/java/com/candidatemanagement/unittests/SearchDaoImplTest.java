package com.candidatemanagement.unittests;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.candidatemanagement.dao.SearchDao;
import com.candidatemanagement.model.Candidate;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
class SearchDaoImplTest {

	@Autowired
	private SearchDao searchDao;
	
	@Test
	public void getSearchResultsTest() {
		List<Candidate> candidates = searchDao.getSearchResults("institute", "djsce");
		assertNotNull(candidates);
	}
	
}
