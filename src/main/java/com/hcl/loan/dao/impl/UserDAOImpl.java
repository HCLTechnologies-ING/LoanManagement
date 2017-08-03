package com.hcl.loan.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hcl.loan.dao.UserDAO;
import com.hcl.loan.model.Address;
import com.hcl.loan.model.User;

@Repository
@PropertySource("classpath:/sql.properties")
public class UserDAOImpl implements UserDAO {

	private static final String FETCH_USER_BYID_STATUS = "SELECT * FROM User where user_id = ? and status = ?";
	private static final String DUPLICATE_USER_CHK="SELECT * FROM User where email_id = ? or (upper(first_name)=upper(?) and date_format(dateofbirth,'%Y-%m-%d')=date_format(?,'%Y-%m-%d'))";
	private static final String UPDATE_USER_STATUS = "update user set status = ? where user_id = ?";
	private static final String INSERT_USER = "INSERT INTO USER(FIRST_NAME , LAST_NAME, ROLE_ID, GENDER, DATEOFBIRTH, PASSWORD, HNI_FLAG, EMAIL_ID, MOBILE_NUMBER, STATUS, PREFERRED_LANG, CURRENT_EMPLOYER, BANK_ACCOUNT_NO , BANK_NAME, BANK_IFSC_CODE, REPAYMENT_MODE,CREATED_DATE,MODIFIED_DATE) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String INSERT_USER_ADD = "INSERT INTO USER_ADDRESS(USER_ID,ADDRESS_TYPE,ADDRESS1,ADDRESS2,CITY,STATE,COUNTRY,PINCODE) VALUES(?,?,?,?,?,?,?,?)";
	private static final String FETCH_USER_ADDRESS="select * from user_address where user_id=?";
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
		logger.debug("fetchUser(id) - Method Input - " + env.toString());
		User user;
		if (userId == null) {
			return new User();
		} else {
			logger.debug("Query - " + env.getProperty("LMS.USER.SQL.FETCH_USER_BYID_STATUS"));
			logger.debug("Query - " + env.getProperty("LMS.USER.SQL.DUPLICATE_USER_CHK"));
			logger.debug("Query - " + env.getProperty("LMS.USER.SQL.UPDATE_USER_STATUS"));
			logger.debug("Query - " + env.getProperty("LMS.USER.SQL.INSERT_USER"));
			logger.debug("Query - " + env.getProperty("LMS.USER.SQL.INSERT_USER_ADD"));
			logger.debug("Query - " + env.getProperty("LMS.USER.SQL.FETCH_USER_ADDRESS"));
			logger.debug("Query - " + env.getProperty("LMS.USER.SQL.SELECT_MAX_USERID"));
			logger.debug("Query - " + env.getProperty("LMS.USER.SQL.FETCH_USER_BYID_STATUS"));
			user=jdbcTemplate.queryForObject(FETCH_USER_BYID_STATUS, new Object[] { userId, "ACTIVE" },
					new UserRowMapper());
			user.setUserAddresses(fetchUserAddress(userId));
		}
		return user;
	}
	
	private List<Address> fetchUserAddress(Long userId) {

		logger.debug("fetchUser(id) - Method Input - " + userId);

		if (userId == null) {
			return new ArrayList();
		} else {
			logger.debug("Query - " + env.getProperty("FETCH_USER_ADDRESS"));
			return jdbcTemplate.query(FETCH_USER_ADDRESS, new AddressRowMapper(),userId);
		}

	}

	@Override
	public User updateUser(Long userId, User user) {

		jdbcTemplate.update(UPDATE_USER_STATUS, user.getStatus(), userId);
		return user;
	}

	
	@Override
	public Integer persistUser(User user) {

		Integer ret = Integer.getInteger("-2");
		
		jdbcTemplate.update(INSERT_USER, user.getFirstName(), user.getLastName(), user.getRole(), user.getGender(),
				user.getDateofbirth(), user.getPassword(), user.getHniFlag(), user.getEmailId(), user.getMobileNumber(),
				"ACTIVE", user.getPreferredLang(), user.getCurrentEmployer(), user.getBankAccountNo(),
				user.getBankName(), user.getBankIfscCode(), user.getRepaymentMode(), new Date(), new Date());

		String userId = jdbcTemplate.queryForObject(SELECT_MAX_USERID, String.class);
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
	public boolean existingUserCheck(User user) {

		if (user == null) {
			return false;
		} else {

			List lst = jdbcTemplate.query(DUPLICATE_USER_CHK, new Object[] { user.getEmailId(), user.getFirstName(),user.getDateofbirth() }, new UserRowMapper());
			if(lst.isEmpty()) {
				return false;
			}else {
				return true;
			}
		}

	}
	
	

}
