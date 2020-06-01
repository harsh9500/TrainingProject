package com.candidatemanagement.dao;

import java.util.List;

import com.candidatemanagement.model.Candidate;

public interface SearchDao {

	public List<Candidate> getSearchResults(String criterion, String term);

}
