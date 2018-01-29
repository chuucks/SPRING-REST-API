package org.codesolt.util;

import java.time.Duration;

public class TimeUtil {

	public static String formatDuration(Duration duration) {
		return duration.getSeconds() + "." + duration.getNano() + " s";
	}	
}
