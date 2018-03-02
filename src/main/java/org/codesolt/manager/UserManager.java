package org.codesolt.manager;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import org.codesolt.model.User;
import org.codesolt.model.UserList;
import org.codesolt.repository.UserRepository;
import org.codesolt.util.EncodeUtil;
import org.codesolt.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Log4j
@Component("userManager")
public class UserManager {	
	
	@Autowired
	private UserRepository userRepo;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public UserList createUser(User user) {
		Instant start = Instant.now();
		UserList userList = new UserList();		
		try {
			if(user.getPassword() != null) {
				user.setPassword(EncodeUtil.bCryptencodeString(user.getPassword()));
				userRepo.save(user);
				userList.setSuccess(true);
			} else
				userList.setSuccess(false);
		} catch(Exception ex) {
			ex.printStackTrace();
			log.error(ex.toString());
			userList.setError(ex.toString());
			userList.setSuccess(false);
		}
		userList.setDuration(TimeUtil.formatDuration(Duration.between(start, Instant.now())));
		return userList;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public UserList updateUser(User user) {
		Instant start = Instant.now();
		UserList userList = new UserList();		
		try {
			Integer id = userRepo.findIdByUserName(user.getUserName());
			if(id != null) {
				user.setId(id);
				userRepo.save(user);
				userList.setSuccess(true);
			} else
				userList.setSuccess(false);
		} catch(Exception ex) {
			ex.printStackTrace();
			log.error(ex.toString());
			userList.setError(ex.toString());
			userList.setSuccess(false);
		}
		userList.setDuration(TimeUtil.formatDuration(Duration.between(start, Instant.now())));
		return userList;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public UserList deleteUser(String userName) {
		Instant start = Instant.now();
		UserList userList = new UserList();
		try {
			userRepo.deleteByUserName(userName);
			userList.setSuccess(true);
		} catch(Exception ex) {
			ex.printStackTrace();
			log.error(ex.toString());
			userList.setError(ex.toString());
			userList.setSuccess(false);
		}
		userList.setDuration(TimeUtil.formatDuration(Duration.between(start, Instant.now())));
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
			log.error(ex.toString());
			userList.setError(ex.toString());
			userList.setSuccess(false);
		}
		userList.setDuration(TimeUtil.formatDuration(Duration.between(start, Instant.now())));
		return userList;
	}
}

