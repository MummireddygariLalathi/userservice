package com.cts.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.User;
import com.cts.service.UserService;

@RestController
@RequestMapping("/secure")
public class SecureController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@RequestMapping("/user/users")
	public String loginSuccess() {
		logger.info("Adding the login reviews {}",loginSuccess());
		return "Login Successful!";
	}

	@RequestMapping(value = "/user/email", method = RequestMethod.POST)
	public User findByEmail(@RequestBody String email) {
		logger.info("Adding the email reviews {}",email);
		return userService.getByEmail(email);
	}

	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public User updateUser(@RequestBody User user) {
		logger.info("update user reviews {}",user);
		return userService.addUser(user);
	}
}
