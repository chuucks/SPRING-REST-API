package org.codesolt.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

import org.codesolt.model.User;
import org.codesolt.model.UserList;
import org.codesolt.repository.UserRepository;

@Component("userManager")
public class UserManager {
	
	@Autowired
	private UserRepository userRepo;
	private UserList userList;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public User createUser(User user) {
			return userRepo.save(user);
	};
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Long deleteUser(String username) {
		return userRepo.deleteByUserName(username);
	};
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public UserList getUsers(String username) {
		if(username != null) {
			List<User> users = userRepo.findByUserName(username);
			userList = new UserList();
			userList.setUserList(users);
			userList.setResults(users.size());
			return userList;
		} else { 
			List<User> users = userRepo.findAll();
			userList = new UserList();
			userList.setUserList(users);
			userList.setResults(users.size());
			return userList;
		}
	};	
}
