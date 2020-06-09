package com.candidatemanagement.unittests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.candidatemanagement.dao.CandidateDaoImpl;
import com.candidatemanagement.model.Candidate;
import com.candidatemanagement.model.CandidateRowMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
class CandidateDaoImplTest {
	
	@Autowired
	private CandidateDaoImpl candidateDao;
	
	@MockBean
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void getAllCandidatesTest() {
		when(jdbcTemplate.query(Mockito.anyString(),Mockito.any(CandidateRowMapper.class))).thenReturn(
				Stream.of(
					new Candidate("Harsh","harsh@gmail.com","DJSCE",1234567890,"SDE","Mumbai","C++ Java","2020-05-11"),
					new Candidate("Prihaan","prihaan@gmail.com","NSIT",1324567890,"SE","Chennai","Python Java","2020-05-13")
					).collect(Collectors.toList())
			);
		assertEquals(2,candidateDao.getAllCandidates().size());
	}
}
