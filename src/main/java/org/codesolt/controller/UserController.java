package org.codesolt.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.codesolt.manager.UserManager;
import org.codesolt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	final static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserManager userManager;
		
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Crea un nuevo usuario", 
		notes = "Proveer en el cuerpo del request los atributos del usuario en formato Json")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("User: " + auth.getName() + ", Method: getTicketByRefNum" + ", Role: " + auth.getAuthorities());
		userManager.createUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);		
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Obtiene un usuario (por username)", 
		notes = "Proveer en la url el username del usuario que se desea obtener")
	public ResponseEntity<User> getUser(@Valid @RequestBody User user) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("User: " + auth.getName() + ", Method: getTicketByRefNum" + ", Role: " + auth.getAuthorities());
		userManager.createUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);		
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@ApiOperation(value = "Elimina un usuario", 
		notes = "Proveer en la url el username del usuario que se desea eliminar")
	public ResponseEntity<User> getUser(@Valid @RequestBody User user) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("User: " + auth.getName() + ", Method: getTicketByRefNum" + ", Role: " + auth.getAuthorities());
		userManager.createUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);		
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@ApiOperation(value = "Actualiza un usuario", 
		notes = "Proveer en el cuerpo del request los atributos del usuario en formato Json")
	public ResponseEntity<User> getUser(@Valid @RequestBody User user) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("User: " + auth.getName() + ", Method: getTicketByRefNum" + ", Role: " + auth.getAuthorities());
		userManager.createUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);		
	}
	
}
