package com.hcl.loan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.loan.dao.UserDAO;
import com.hcl.loan.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDao;

	@Override
	public User fetchUser(Long userId) {

		return userDao.findOne(userId);
	}
 
	@Override
	public User updateUser(Long userId, User user) {
		return userDao.save(user);
	}

	@Override
	public User persistUser(User user) {
		return userDao.save(user);
	}

	@Override
	public void deleteUser(Long userId) {
		userDao.delete(userId);
	}
}
