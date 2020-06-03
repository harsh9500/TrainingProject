package com.candidatemanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candidatemanagement.dao.SearchDao;
import com.candidatemanagement.dao.SearchDaoImpl;
import com.candidatemanagement.model.Candidate;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	SearchDao searchDao = new SearchDaoImpl();
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<Candidate> getSearchResults(String criterion, String term) {
		logger.info("Returning search results for criterion "+criterion);
		return searchDao.getSearchResults(criterion,term);
	}

}
