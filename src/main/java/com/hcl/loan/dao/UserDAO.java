package com.hcl.loan.dao;

import com.hcl.loan.model.User;

public interface UserDAO {

	public User fetchUser(Long userId);	
	public User updateUser(Long userId, User user);
	 
	public Integer persistUser(User user );
	
	public void deleteUser(Long userId);
	
	public boolean existingUserCheck(User user);
	
}
