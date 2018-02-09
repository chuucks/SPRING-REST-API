package org.codesolt;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.codesolt.configuration.RestConfiguration;
import org.codesolt.model.User;
import org.codesolt.repository.UserRepository;
import org.codesolt.util.EncodeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RestConfiguration.class })
@WebAppConfiguration
public class TestReposiory {

	/* 
	 * For PROD applications,
	 * test the following operations 
	 * pointing to QA or DEV only
	*/
	
	@Autowired
	private UserRepository userRepo;
	private static final String USER_NAME = "newuser13";
	private static final String USER_MAIL = "newuser13@mail.com";

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
	public void ensureCRUDoperations() {
		User user = new User();
		user.setUserName(USER_NAME);
		user.setEmail(USER_MAIL);
		user.setRole("ROLE_USER");
		user.setActive(1);
		user.setPassword(EncodeUtil.bCryptencodeString("password"));
		
		User newUser = userRepo.save(user);
		assertTrue(newUser instanceof User);
		assertTrue(newUser == user);
				
		newUser.setActive(0);
		User updateUser = userRepo.save(newUser);
		assertTrue(newUser instanceof User);
		assertTrue(updateUser != newUser);
		
		userRepo.delete(updateUser);
	}
}
