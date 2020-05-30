package com.candidatemanagement.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CandidateRowMapper implements RowMapper <Candidate> {

	@Override
	public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
		Candidate candidate = new Candidate();
		candidate.setId(rs.getLong("id"));
		candidate.setName(rs.getString("name"));
		candidate.setEmail(rs.getString("email"));
		return candidate;
	}
}