package org.codesolt;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.codesolt.configuration.RestConfiguration;
import org.codesolt.model.User;
import org.codesolt.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RestConfiguration.class })
@WebAppConfiguration
public class TestRepository {

	/* 
	 * For PROD applications,
	 * test the following operations 
	 * pointing to QA or DEV only
	*/
	
	@Autowired
	private UserRepository userRepo;
	private User user;

	@Test
	public void ensureGetIdByUsername() {
		Integer id = userRepo.findIdByUserName("user3");
		assertNotNull(id);
		assertTrue(id > 0);
	}
	
	@Test
	public void ensureGetByUsername() {
		List<User> users = userRepo.findByUserName("user3");
		User user = users.get(0);
		assertNotNull(user);
		assertTrue(user instanceof User);
	}
	
	@Test
	public void ensureGetAll() {
		List<User> users = userRepo.findAll();
		assertNotNull(users);
		assertTrue(users.size() > 0);		
	}
	
	@Test
	public void ensureCreateUser() {
		userRepo();
	}

	@Test
	public void updateUser() {
		
	}
	
	@Test
	public void ensureDeleteUser() {
		
	}
}
