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

import com.candidatemanagement.dao.TrendsDao;
import com.candidatemanagement.model.Result;
import com.candidatemanagement.service.TrendsService;

@RunWith(SpringRunner.class)
@SpringBootTest
class TrendsServiceImplTest {

	@Autowired
	private TrendsService trendsService;
	
	@MockBean
	private TrendsDao trendsDao;
	
	@Test
	public void getLocationTrendsTest() {
		Result r = new Result();
		r.setName("Chennai");
		r.setValue("2");
		System.out.println(r.getName());
		System.out.println(r.getValue());
		when(trendsDao.getLocationTrends()).thenReturn(
				Stream.of(
						new Result("Mumbai","2"),
						new Result("Bengaluru","2"),
						r
					).collect(Collectors.toList()));
		assertEquals(3,trendsService.getLocationTrends().size());
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
