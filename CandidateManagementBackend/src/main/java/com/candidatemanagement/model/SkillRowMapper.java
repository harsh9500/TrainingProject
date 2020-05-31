package com.candidatemanagement.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SkillRowMapper implements RowMapper <Skill> {

	@Override
	public Skill mapRow(ResultSet rs, int rowNum) throws SQLException {
		Skill skill = new Skill();
		skill.setSkillId(rs.getInt("id"));
		skill.setSkillName(rs.getString("name"));
		return skill;
	}
}