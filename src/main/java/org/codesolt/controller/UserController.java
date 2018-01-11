package org.codesolt.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.codesolt.manager.UserManager;
import org.codesolt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	final static Logger logger = Logger.getLogger(UserController.class);
	private static Authentication auth;
	
	@Autowired
	private UserManager userManager;	
	
	@ApiOperation(value = "Crea un nuevo usuario", notes = "Acceso únicamente con rol de Administrador")	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("User: " + auth.getName() + ", Method: createUser" + ", Role: " + auth.getAuthorities());		
		return new ResponseEntity<User>(userManager.createUser(user), HttpStatus.OK);		
	}
	
	@ApiOperation(value = "Actualiza un usuario", notes = "Acceso únicamente con rol de Administrador")	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
		auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("User: " + auth.getName() + ", Method: updateUser" + ", Role: " + auth.getAuthorities());		
		return new ResponseEntity<User>(userManager.createUser(user), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Elimina un usuario por username", notes = "Acceso únicamente con rol de Administrador")	
	@RequestMapping(value = {"/{username}", "{username}"}, method = RequestMethod.DELETE)
	public ResponseEntity<Long> deleteUser(@Valid @PathVariable("username") String userName) {
		auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("User: " + auth.getName() + ", Method: deleteUser" + ", Role: " + auth.getAuthorities());		
		return new ResponseEntity<Long>(userManager.deleteUser(userName), HttpStatus.OK);		
	}
	
	@ApiOperation(value = "Obtiene un usuario por username", notes = "Acceso únicamente con rol Administrador")
	@RequestMapping(value = {"/{username}", "{username}"}, method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUser(@Valid @PathVariable("username") String userName) {
		auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("User: " + auth.getName() + ", Method: getUser" + ", Role: " + auth.getAuthorities());		
		return new ResponseEntity<List<User>>(userManager.getUsers(userName), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Obtiene todos los usuarios", notes = "Acceso únicamente con rol Administrador")
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {
		auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("User: " + auth.getName() + ", Method: getUsers" + ", Role: " + auth.getAuthorities());		
		return new ResponseEntity<List<User>>(userManager.getUsers(null), HttpStatus.OK);
	}
	
}
