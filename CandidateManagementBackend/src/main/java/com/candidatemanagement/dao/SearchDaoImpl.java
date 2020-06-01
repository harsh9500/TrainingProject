package com.candidatemanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.candidatemanagement.model.Candidate;
import com.candidatemanagement.model.CandidateRowMapper;

@Repository
public class SearchDaoImpl implements SearchDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Candidate> getSearchResults(String criterion, String term) {
		return jdbcTemplate.query("select * from candidate where "+criterion+" like '%"+term+"%'",new CandidateRowMapper());
	}

}
