package org.codesolt.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import lombok.extern.log4j.Log4j;

@Log4j
public class ActivityLogger {

	private static Authentication auth;
	
	public static void logMethod(String method) {
		auth = SecurityContextHolder.getContext().getAuthentication();
		log.info("User: " + auth.getName() + ", Method: " + method + ", Role: " + auth.getAuthorities());
	}
}
