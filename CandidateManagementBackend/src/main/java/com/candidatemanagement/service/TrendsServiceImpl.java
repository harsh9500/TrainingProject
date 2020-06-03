package com.candidatemanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candidatemanagement.dao.TrendsDao;
import com.candidatemanagement.model.Result;

@Service
public class TrendsServiceImpl implements TrendsService {

	@Autowired
	TrendsDao trendsDao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<Result> getLocationTrends() {
		logger.info("Returning trends across locations");
		return trendsDao.getLocationTrends();
	}

	@Override
	public List<Result> getInstituteTrends() {
		logger.info("Returning trends across institutes");
		return trendsDao.getInstituteTrends();
	}

	@Override
	public List<Result> getDescriptionTrends() {
		logger.info("Returning trends across descriptions");
		return trendsDao.getDescriptionTrends();
	}
	
	

}
