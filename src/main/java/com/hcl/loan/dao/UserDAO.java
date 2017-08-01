package com.hcl.loan.dao;

import org.springframework.data.repository.CrudRepository;

import com.hcl.loan.model.User;

public interface UserDAO extends CrudRepository<User, Long>{

	
}
