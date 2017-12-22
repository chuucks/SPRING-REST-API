package org.codesolt.manager;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import org.codesolt.model.User;

@Component
public class UserManager {
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public User createUser(User user) {
			return new User();
	};
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public User deleteUser() {
		return new User();
	};
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public User updateUser() {
		return new User();
	};
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public User readUser() {
		return new User();
	};
	
}
