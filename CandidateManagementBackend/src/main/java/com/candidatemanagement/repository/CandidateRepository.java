package com.candidatemanagement.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.candidatemanagement.model.Candidate;
import com.candidatemanagement.model.CandidateRowMapper;

@Repository
public class CandidateRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public List<Candidate> findAll() {
		return jdbcTemplate.query("select * from candidate", new CandidateRowMapper());
	}
	
	public Optional < Candidate > findById(long id) {
		return Optional.of(jdbcTemplate.queryForObject("select * from candidate where id=?", new Object[] {
                id
            },
            new BeanPropertyRowMapper < Candidate > (Candidate.class)));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from candidate where id=?", new Object[] {
            id
        });
    }

    public int insert(Candidate candidate) {
        return jdbcTemplate.update("insert into candidate (id, name, email) " + "values(?, ?, ?)",
            new Object[] {
                candidate.getId(), candidate.getName(), candidate.getEmail()
            });
    }

    public int update(Candidate candidate) {
        return jdbcTemplate.update("update candidate " + " set name = ?, email = ? " + " where id = ?",
            new Object[] {
            		candidate.getName(), candidate.getEmail(), candidate.getId()
            });
    }

}
