package com.candidatemanagement.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.candidatemanagement.model.Candidate;
import com.candidatemanagement.model.CandidateRowMapper;

@Repository
public class CandidateDaoImpl implements CandidateDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Candidate> getAllCandidates() {
		return jdbcTemplate.query("select * from candidate", new CandidateRowMapper());
	}
	
	@Override
	public Optional < Candidate > getCandidateById(long id){
		try {
		return Optional.of(jdbcTemplate.queryForObject("select * from candidate where id=?", new Object[] {
                id
            },
            new BeanPropertyRowMapper < Candidate > (Candidate.class)));
		}
		catch(EmptyResultDataAccessException e)
		{
			return null;
		}
    }

    

    @Override
    public Boolean addCandidate(Candidate candidate) {
    	
    	String query="insert into candidate (name,email) values(?,?)";
    	
    	return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, candidate.getName());
				ps.setString(2, candidate.getEmail());
				return ps.execute();
			}});
    	
    }

    @Override
    public int updateCandidate(Candidate candidate, long id) {
        int [] types= {Types.VARCHAR,Types.VARCHAR,Types.INTEGER};
    	return jdbcTemplate.update("update candidate " + " set name = ?, email = ? "+" where id = ?",
            new Object[] {candidate.getName(), candidate.getEmail(), id},types);
    }
    
    @Override
    public int deleteCandidate(long id) {
        return jdbcTemplate.update("delete from candidate where id=?", id);
    }

}
