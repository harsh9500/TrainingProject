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

import com.candidatemanagement.controller.TrendsController;
import com.candidatemanagement.model.Result;
import com.candidatemanagement.service.TrendsService;

@RunWith(SpringRunner.class)
@SpringBootTest
class TrendsControllerTest {

	@Autowired
	private TrendsController trendsController;
	
	@MockBean
	private TrendsService trendsService;
	
	@Test
	public void getLocationTrendsTest() {
		when(trendsService.getLocationTrends()).thenReturn(
				Stream.of(
						new Result("Mumbai","2"),
						new Result("Chennai","2")
					).collect(Collectors.toList())
			);
		assertEquals(2,trendsController.getLocationTrends().size());
	}
	
	@Test
	public void getDescriptionTrendsTest() {
		when(trendsService.getDescriptionTrends()).thenReturn(
				Stream.of(
						new Result("SE","2"),
						new Result("SDE","2")
					).collect(Collectors.toList())
			);
		assertEquals(2,trendsController.getDescriptionTrends().size());
	}
	
	@Test
	public void getInstituteTrendsTest() {
		when(trendsService.getInstituteTrends()).thenReturn(
				Stream.of(
						new Result("DJSCE","2"),
						new Result("TSEC","2")
					).collect(Collectors.toList())
			);
		assertEquals(2,trendsController.getInstituteTrends().size());
	}
	
}