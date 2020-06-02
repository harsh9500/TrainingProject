package com.candidatemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candidatemanagement.dao.TrendsDao;
import com.candidatemanagement.model.Result;

@Service
public class TrendsServiceImpl implements TrendsService {

	@Autowired
	TrendsDao trendsDao;
	
	@Override
	public List<Result> getLocationTrends() {
		return trendsDao.getLocationTrends();
	}

	@Override
	public List<Result> getInstituteTrends() {
		return trendsDao.getInstituteTrends();
	}

	@Override
	public List<Result> getDescriptionTrends() {
		return trendsDao.getDescriptionTrends();
	}
	
	

}
