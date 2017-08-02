package com.hcl.loan.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.loan.controller.UserRegistrationController;
import com.hcl.loan.dao.impl.UserRowMapper;
import com.hcl.loan.model.Address;
import com.hcl.loan.model.User;
import com.hcl.loan.dao.*;;
@Repository
@PropertySource("classpath:/sql.properties")
public class UserDAOImpl implements UserDAO {

	private static final String FETCH_USER_BYID = "SELECT * FROM User where user_id = ? and status = ?";
	private static final String UPDATE_USER_STATUS = "update user set status = ? where user_id = ?";
	private static final String INSERT_USER = "INSERT INTO USER(FIRST_NAME , LAST_NAME, ROLE_ID, GENDER, DATEOFBIRTH, PASSWORD, HNI_FLAG, EMAIL_ID, MOBILE_NUMBER, STATUS, PREFERRED_LANG, CURRENT_EMPLOYER, BANK_ACCOUNT_NO , BANK_NAME, BANK_IFSC_CODE, REPAYMENT_MODE,CREATED_DATE,MODIFIED_DATE) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String INSERT_USER_ADD = "INSERT INTO USER_ADDRESS(USER_ID,ADDRESS_TYPE,ADDRESS1,ADDRESS2,CITY,STATE,COUNTRY,PINCODE) VALUES(?,?,?,?,?,?,?,?)";
	private static final String DELETE_USER = "DELETE from User WHERE user_id = ?";
	private static final String SELECT_MAX_USERID = "select max(user_id) from user";

	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

	private JdbcTemplate jdbcTemplate;

	@Resource
	private Environment env;

	public UserDAOImpl(DataSource datasource) {
		super();
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public User fetchUser(Long userId) {

		logger.debug("fetchUser(id) - Method Input - " + userId);

		if (userId == null) {
			return new User();
		} else {
			logger.debug("Query - " + env.getProperty("FETCHUSER"));
			return (User) jdbcTemplate.queryForObject(FETCH_USER_BYID, new Object[] { userId, "ACTIVE" },
					new UserRowMapper());
		}

	}

	@Override
	public User updateUser(Long userId, User user) {
		
		jdbcTemplate.update(UPDATE_USER_STATUS, user.getStatus(), userId);
		return user;
	}

	@Transactional
	@Override
	public Integer persistUser(User user) {

		Integer ret = Integer.parseInt("1");
		

		jdbcTemplate.update(INSERT_USER, user.getFirstName(), user.getLastName(), user.getRole(), user.getGender(),
				user.getDateofbirth(), user.getPassword(), user.getHniFlag(), user.getEmailId(), user.getMobileNumber(),
				"ACTIVE", user.getPreferredLang(), user.getCurrentEmployer(), user.getBankAccountNo(),
				user.getBankName(), user.getBankIfscCode(), user.getRepaymentMode(), new Date(), new Date());

		String userId = (String) jdbcTemplate.queryForObject(SELECT_MAX_USERID, String.class);
		user.setUserId(userId);
		ret = persistUserAddress(userId, user.getAddresses());

		return ret;

	}

	public Integer persistUserAddress(String userId, List<Address> userAddress) {
		

		if (userAddress == null || userAddress.isEmpty()) {
			return -1;
		} else {

			for (Address addr : userAddress) {
				jdbcTemplate.update(INSERT_USER_ADD, userId, addr.getAddressType(), addr.getAddress1(),
						addr.getAddress2(), addr.getCity(), addr.getState(), addr.getCountry(), addr.getPincode());

			}
		}
		return 1;
	}

	@Override
	public void deleteUser(Long userId) {
		
		jdbcTemplate.update(UPDATE_USER_STATUS, "INACTIVE", userId);

	}

	@Override
	public boolean userExistWithStatus(Long userId, String status) {

		if (userId == null) {
			return false;
		} else {

			jdbcTemplate.queryForObject(FETCH_USER_BYID, new Object[] { userId, status },
					new UserRowMapper());
			return true;
		}

	}

}