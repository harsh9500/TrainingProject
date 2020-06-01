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
		candidate.setInstitute(rs.getString("institute"));
		candidate.setContact(rs.getLong("contact"));
		candidate.setDescription(rs.getString("description"));
		candidate.setLocation(rs.getString("location"));
		candidate.setSkills(rs.getString("skills"));
		candidate.setJoiningDate(rs.getString("joiningDate"));
		candidate.setFeedback(rs.getString("feedback"));
		return candidate;
	}
}