package com.hcl.loan.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.hcl.loan.service.*;
import com.hcl.loan.dao.UserDAO;
import com.hcl.loan.model.User;

@PropertySource("classpath:error.properties")
@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	UserDAO userDao;

	@Autowired
	Environment env;


	@Override
	public User fetchUser(Long userId) {

		logger.debug("fetchUser(id) - Method Input - Id:" + userId);

		User fetchedUser = userDao.fetchUser(userId);
		logger.debug("updateUser(id, user) - Method Output - Fetched User:" + fetchedUser);

		return fetchedUser;
	}

	@Override
	public User updateUser(Long userId, User user) {

		logger.debug("updateUser(id, user) - Method Input - ID:" + userId + "User:" + user);
		User updateUser = userDao.updateUser(userId, user);
		logger.debug("updateUser(id, user) - Method Output - Updated User:" + updateUser);

		return updateUser;
	}

	@Override
	public Integer persistUser(User user) {

		logger.debug("persistUser(id) - Method Input - User:" + user);

		Integer insertedRecordCount = userDao.persistUser(user);
		logger.debug("persistedUser(user) - Method Output - Inserted Record Count:" + insertedRecordCount);

		return insertedRecordCount;
	}

	@Override
	public void deleteUser(Long userId) {
		userDao.deleteUser(userId);
	}
	
	@Override
	public boolean userExistWithStatus(Long userId, String status) {
		
		return userDao.userExistWithStatus(userId,status);

	}

}
