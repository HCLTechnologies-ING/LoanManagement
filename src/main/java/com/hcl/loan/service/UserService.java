package com.hcl.loan.service;

import com.hcl.loan.model.User;

public interface UserService {

	public User fetchUser(Long userId);	
	public User updateUser(Long userId, User user);
	 
	public Integer persistUser(User user);
	
	public void deleteUser(Long userId);
	
	
}
