package com.candidatemanagement.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ResultRowMapper implements RowMapper <Result> {

	@Override
	public Result mapRow(ResultSet rs, int rowNum) throws SQLException {
		Result result = new Result();
		result.setName(rs.getString("name"));
		result.setValue(rs.getString("value"));
		return result;
	}
}