package org.codesolt.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPassword {

	final static Logger logger = Logger.getLogger(TestPassword.class);
	
	@Test
	public void testPassword() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoded = encoder.encode("myPassword");
		logger.info(encoded);
	}
	
}
