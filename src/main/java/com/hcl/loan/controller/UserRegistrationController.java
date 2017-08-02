package com.hcl.loan.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.loan.model.User;
import com.hcl.loan.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserRegistrationController {

	private static final Logger logger = Logger.getLogger(UserRegistrationController.class);

	@Autowired
	private UserService userService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> fetchUser(@PathVariable("id") Long userId) {

		logger.debug("fetchUser(id) - Method Input - " + userId);
		if (null == userId) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		User user = userService.fetchUser(userId);
		logger.debug("fetchUser(id) - fetched User data - " + user);
		if (null == user) {
			return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @Valid @RequestBody User user) {

		logger.debug("updateUser(id) - Method Input - ID:" + userId + "User:" + user);
		User updatedUser = userService.updateUser(userId, user);

		logger.debug("updateUser(id) - Updated User - ID:" + userId + "User:" + updatedUser);
		if (null == updatedUser) {
			return new ResponseEntity<>(updatedUser, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registerUserData(@Valid @RequestBody User user) {
		logger.debug("updateUser(id) - Method Input - User:" + user);
		return new ResponseEntity<>(userService.persistUser(user), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long userId) {
		userService.deleteUser(userId);
	}
}