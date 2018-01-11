package org.codesolt.util;

import java.util.Base64;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodeUtil {	
	
	public static String bCryptencodeString(String string) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(string);
	}

	public static String encodeBase64String(String string) {
		return Base64.getEncoder().encodeToString(string.getBytes());
		
	}
	
	public static String decodeBase64String(String string) {
		return new String(Base64.getDecoder().decode(string.getBytes()));
	}
}
