package com.company.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public class UserRepository {
	
	@Autowired
	JdbcTemplate template;
	
	public boolean getUser(@RequestParam("name") String name, @RequestParam("password") String password) {
		
		Object[] obj = {name,password};
		
		Integer count = template.queryForObject("select count(*) from users where name=? and password=?", 
			obj, Integer.class );
		
		return count == 1;
		
	}

}
