package org.codesolt.controller;

import javax.validation.Valid;

import org.codesolt.manager.UserManager;
import org.codesolt.model.User;
import org.codesolt.model.UserList;
import org.codesolt.util.ActivityLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/user/")
public class UserController {
	
	@Autowired
	private UserManager userManager;
	
	@ApiOperation(value = "Create new User", notes = "Access only for Admin Role")	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<UserList> createUser(@Valid @RequestBody User user) {
		ActivityLogger.logMethod("createUser(user)");
		return new ResponseEntity<UserList>(userManager.createUser(user), HttpStatus.OK);		
	}
	
	@ApiOperation(value = "Update User", notes = "Access only for Admin Role")	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<UserList> updateUser(@Valid @RequestBody User user) {
		ActivityLogger.logMethod("updateUser(user)");
		return new ResponseEntity<UserList>(userManager.createUser(user), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete User by username", notes = "Access only for Admin Role")	
	@RequestMapping(value = "{username}", method = RequestMethod.DELETE)
	public ResponseEntity<UserList> deleteUser(@Valid @PathVariable("username") String userName) {
		ActivityLogger.logMethod("deleteUser(userName)");
		return new ResponseEntity<UserList>(userManager.deleteUser(userName), HttpStatus.OK);		
	}
	
	@ApiOperation(value = "Get User by username", notes = "Access only for Admin Role")
	@RequestMapping(value = {"{username}"}, method = RequestMethod.GET)
	public ResponseEntity<UserList> getUser(@Valid @PathVariable("username") String userName) {
		ActivityLogger.logMethod("getUsers(userName)");
		return new ResponseEntity<UserList>(userManager.getUsers(userName), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Users", notes = "Access only for Admin Role")
	@RequestMapping(value = {""}, method = RequestMethod.GET)
	public ResponseEntity<UserList> getUsers() {
		ActivityLogger.logMethod("getUsers()");
		return new ResponseEntity<UserList>(userManager.getUsers(null), HttpStatus.OK);
	}
}
