package com.company.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.company.model.Users;

@Component
public class UserRowMapper implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new Users(rs.getLong("id"),
				rs.getString("name"),
				rs.getString("password"));
	}

}
