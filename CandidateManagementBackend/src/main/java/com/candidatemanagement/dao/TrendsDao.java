package com.candidatemanagement.dao;

import java.util.List;

import com.candidatemanagement.model.Result;

public interface TrendsDao {

	public List<Result> getLocationTrends();
	public List<Result> getInstituteTrends();
	public List<Result> getDescriptionTrends();
}
