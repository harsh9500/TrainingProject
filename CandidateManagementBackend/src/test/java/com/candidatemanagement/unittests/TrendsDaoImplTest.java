package com.candidatemanagement.unittests;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.candidatemanagement.dao.TrendsDao;
import com.candidatemanagement.model.Result;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
class TrendsDaoImplTest {

	@Autowired
	private TrendsDao trendsDao;
	
	@Test
	public void getLocationTrendsTest() {
		List<Result> results = trendsDao.getLocationTrends();
		assertNotNull(results);
	}
	
	@Test
	public void getDescriptionTrendsTest() {
		List<Result> results = trendsDao.getDescriptionTrends();
		assertNotNull(results);
	}
	
	@Test
	public void getInstituteTrendsTest() {
		List<Result> results = trendsDao.getInstituteTrends();
		assertNotNull(results);
	}
	
}
