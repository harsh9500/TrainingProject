package com.candidatemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candidatemanagement.dao.SearchDao;
import com.candidatemanagement.dao.SearchDaoImpl;
import com.candidatemanagement.model.Candidate;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	SearchDao searchDao = new SearchDaoImpl();
	
	@Override
	public List<Candidate> getSearchResults(String criterion, String term) {
		return searchDao.getSearchResults(criterion,term);
	}

}
