package com.tyss.forestrymanagementsystemboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.forestrymanagementsystemboot.dto.UserBean;
import com.tyss.forestrymanagementsystemboot.dto.UserResponse;
import com.tyss.forestrymanagementsystemboot.services.UserServices;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserServices userServices;

	@PostMapping(path = "/fmsboot/addUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse addUser(@RequestBody UserBean userBean) {
		UserResponse response = new UserResponse();

		if (userServices.addUser(userBean)) {
			response.setMessage("Success");
			response.setDescription("User added successfully");
			response.setStatusCode(201);
			response.setUserBean((Arrays.asList(userBean)));

		} else {
			response.setMessage("Failure");
			response.setDescription("User not added, Email already exists");
			response.setStatusCode(401);
		}
		return response;
	}

	@PutMapping(path = "/fmsboot/updateUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse updateUser(@RequestBody UserBean bean) {
		UserResponse response = new UserResponse();

		if (userServices.modifyUser(bean)) {
			response.setMessage("Success");
			response.setDescription("Email Id updated successfully");
			response.setStatusCode(201);
			response.setUserBean((Arrays.asList(bean)));

		} else {
			response.setMessage("Failure");
			response.setDescription("Email not updated, Id not found");
			response.setStatusCode(401);
		}
		return response;
	}

	@DeleteMapping(path = "/fmsboot/deleteUser/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse deleteUser(@PathVariable("userId") int userId) {
		UserResponse response = new UserResponse();

		if (userServices.deleteUser(userId)) {
			response.setMessage("Success");
			response.setDescription("User deleted successfully");
			response.setStatusCode(201);
		} else {
			response.setMessage("Failure");
			response.setDescription("User not deleted, Id not found");
			response.setStatusCode(401);
		}
		return response;

	}

	@GetMapping(path = "/fmsboot/getUser/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse getUser(@PathVariable("userId") int userId) {
		UserResponse response = new UserResponse();
		UserBean bean = userServices.getUserById(userId);
		if (bean != null) {
			response.setMessage("Success");
			response.setDescription("User found and displayed");
			response.setStatusCode(201);
			response.setUserBean(Arrays.asList(bean));
		} else {
			response.setMessage("Failure");
			response.setDescription("User not found");
			response.setStatusCode(401);
		}
		return response;
	}

	@PostMapping(path = "/fmsboot/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse getAllUsers() {
		UserResponse response = new UserResponse();
		List<UserBean> list = userServices.getAllUser();
		if (list.size() > 0) {
			response.setMessage("Success");
			response.setDescription("Users found and displayed");
			response.setStatusCode(201);
			response.setUserBean(list);
			System.out.println("inside getAllUsers() : "+list.get(0).getFullName() );

		} else {
			response.setMessage("Failure");
			response.setDescription("Empty List");
			response.setStatusCode(401);
		}
		return response;
	}
}
