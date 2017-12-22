package org.codesolt.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

import org.codesolt.model.User;
import org.codesolt.repository.UserRepository;

@Component("userManager")
public class UserManager {
	
	@Autowired
	private UserRepository userRepo;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public User createUser(User user) {
			return userRepo.save(user);
	};
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Long deleteUser(String username) {
		return userRepo.deleteByUserName(username);
	};
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public List<User> getUsers(String username) {
		if(username != null)
			return userRepo.findByUserName(username);
		else 
			return userRepo.findAll();
	};	
}
