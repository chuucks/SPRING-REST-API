package org.codesolt.test;

import java.util.Base64;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EcondeTest {

	final static Logger logger = Logger.getLogger(EcondeTest.class);
	
//	@Test
//	public void encodeString() {
//		String string = "%";
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		logger.info(encoder.encode(string));
//	}
//	
//	@Test
//	public void encodeBase64String() {
//		String string = "%";
//		logger.info(Base64.getEncoder().encodeToString(string.getBytes()));
//		
//	}
//	
//	@Test
//	public void decodeBase64String() {
//		String string = "%";
//		logger.info(new String(Base64.getDecoder().decode(string.getBytes())));
//	}
}
