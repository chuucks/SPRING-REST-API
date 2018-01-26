package org.codesolt.manager;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import org.apache.log4j.Logger;
import org.codesolt.model.User;
import org.codesolt.model.UserList;
import org.codesolt.repository.UserRepository;
import org.codesolt.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component("userManager")
public class UserManager {
	
	final static Logger logger = Logger.getLogger(UserManager.class);	
	
	@Autowired
	private UserRepository userRepo;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public UserList createUser(User user) {
		Instant start = Instant.now();
		UserList userList = new UserList();		
		try {
			userRepo.save(user);			
			userList.setSuccess(true);
			userList.setMessagge("User created");
		} catch(Exception ex) {
			ex.printStackTrace();
			userList.setError("Couldn't complete operation");
			userList.setSuccess(false);
		}
		userList.setDuration(TimeUtils.formatDuration(Duration.between(start, Instant.now())));
		return userList;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public UserList updateUser(User user) {
		Instant start = Instant.now();
		UserList userList = new UserList();
		try {
			user.setId(userRepo.findIdByUserName(user.getUserName()));
			userRepo.save(user);
			userList.setSuccess(true);
			userList.setMessagge("User updated");
		} catch (Exception ex) {
			ex.printStackTrace();
			userList.setError("Couldn't complete operation");
			userList.setSuccess(false);
		}
		userList.setDuration(TimeUtils.formatDuration(Duration.between(start, Instant.now())));
		return userList;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public UserList deleteUser(String userName) {
		Instant start = Instant.now();
		UserList userList = new UserList();
		try {
			userRepo.deleteByUserName(userName);
			userList.setSuccess(true);
			userList.setMessagge("User deleted");
		} catch(Exception ex) {
			ex.printStackTrace();
			userList.setError("Couldn't complete operation");
			userList.setSuccess(false);
		}
		userList.setDuration(TimeUtils.formatDuration(Duration.between(start, Instant.now())));
		return userList;
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public UserList getUsers(String userName) {
		Instant start = Instant.now();
		UserList userList = new UserList();
		List<User> users;
		try {
			if(userName == null)
				users = userRepo.findAll();
			else
				users = userRepo.findByUserName(userName);
			userList.setUsers(users);
			userList.setResults(users.size());
			userList.setSuccess(true);
		} catch (Exception ex) {
			ex.printStackTrace();
			userList.setError("Couldn't complete operation");
			userList.setSuccess(false);
		}
		userList.setDuration(TimeUtils.formatDuration(Duration.between(start, Instant.now())));
		return userList;
	}
}
