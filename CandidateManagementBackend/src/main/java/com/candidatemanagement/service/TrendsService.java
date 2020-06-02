package com.candidatemanagement.service;

import java.util.List;

import com.candidatemanagement.model.Result;

public interface TrendsService {

	public List<Result> getLocationTrends();
	public List<Result> getInstituteTrends();
	public List<Result> getDescriptionTrends();
}
