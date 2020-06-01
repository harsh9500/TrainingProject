package com.candidatemanagement.service;

import java.util.List;

import com.candidatemanagement.model.Candidate;

public interface SearchService {

	public List<Candidate> getSearchResults(String criterion, String term);
}
