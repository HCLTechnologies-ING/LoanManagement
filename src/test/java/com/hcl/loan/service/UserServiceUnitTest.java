package com.hcl.loan.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.OngoingStubbing;

import com.hcl.loan.dao.impl.UserDAOImpl;
import com.hcl.loan.model.Address;
import com.hcl.loan.model.User;
import com.hcl.loan.service.impl.UserServiceImpl;

public class UserServiceUnitTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock
	UserDAOImpl userDao;

	@InjectMocks
	UserServiceImpl userService;

	private User user;

	@Before
	public void setup() throws ParseException {

		MockitoAnnotations.initMocks(this);
		user = getDummyUser();
		userService = new UserServiceImpl();
		// userService.setEmployee(employee);

	}

	@Test
	public void insertEmployeeTestForInsertDoNothing() {


		
		/*Long result =  when(userDao.persistUser(user))*/
				
		//when(userDao.fetchUser(23L)).thenReturn(value);
				
		//Integer result = when(userService.persistUser(user)).thenReturn(0);
		
		//Assert.assertEquals(1, result.longValue());

	}



	private User getDummyUser() {

		User user = new User();
		Address homeAddress = new Address();
		Address officeAddress = new Address();
		List<Address> userAddresses = new ArrayList<Address>();
		user.setFirstName("Sasikumar");
		user.setLastName("Guna");
		user.setBankAccountNo("HDFC123123123");
		user.setBankIfscCode("HDFC000001001");
		user.setDateofbirth(new Date("21/12/1978"));
		user.setEmailId("sasikumar_g@hcl.com");
		user.setGender("Male");
		user.setHniFlag("Y");
		user.setMobileNumber("9884039333");
		user.setPassword("Testuser");
		user.setPreferredLang("EN");
		user.setRepaymentMode("ECS");
		user.setRole("CUST");
		user.setStatus("ACTIVE");
		homeAddress.setAddressType("HOME");
		homeAddress.setAddress1("address1");
		homeAddress.setAddress2("address2");
		homeAddress.setCity("Chennai");
		homeAddress.setState("TamilNadu");
		homeAddress.setPincode(1231231);

		officeAddress.setAddressType("HOME");
		officeAddress.setAddress1("address1");
		officeAddress.setAddress2("address2");
		officeAddress.setCity("Chennai");
		officeAddress.setState("TamilNadu");
		officeAddress.setPincode(1231231);

		userAddresses.add(homeAddress);
		userAddresses.add(officeAddress);

		user.setUserAddresses(userAddresses);

		return user;

	}

}
