package com.candidatemanagement.dao;

import java.util.List;
import java.util.Optional;

import com.candidatemanagement.model.Candidate;

public interface CandidateDao {

	public List<Candidate> getAllCandidates();
	public Optional < Candidate > getCandidateById(long id);
	public Boolean addCandidate(Candidate candidate);
	public int updateCandidate(Candidate candidate, long id);
	public int deleteCandidate(long id);
}
