package com.candidatemanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.candidatemanagement.model.Result;
import com.candidatemanagement.model.ResultRowMapper;

@Repository
public class TrendsDaoImpl implements TrendsDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Result> getLocationTrends() {
		return jdbcTemplate.query("select location as name, count(*) as value from candidate group by location;", new ResultRowMapper());
	}

	@Override
	public List<Result> getInstituteTrends() {
		return jdbcTemplate.query("select institute as name, count(*) as value from candidate group by institute;", new ResultRowMapper());
	}

	@Override
	public List<Result> getDescriptionTrends() {
		return jdbcTemplate.query("select description as name, count(*) as value from candidate group by description;", new ResultRowMapper());
	}
	
	
}
