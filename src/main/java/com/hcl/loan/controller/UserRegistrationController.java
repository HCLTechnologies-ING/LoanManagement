package com.hcl.loan.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.loan.model.User;
import com.hcl.loan.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRegistrationController {

	private static final Logger logger = Logger.getLogger(UserRegistrationController.class);
 
	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<User> fetchUser(@PathVariable("id") Long userId) {

		User user = userService.fetchUser(userId);
		if (null == user) {
			return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user) {

		User updatedUser = userService.updateUser(userId, user);

		if (null == updatedUser) {
			return new ResponseEntity<>(updatedUser, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<User> registerUserData(@ModelAttribute @Valid @RequestBody User user) {
		return new ResponseEntity<>(userService.persistUser(user), HttpStatus.CREATED);
	}
}