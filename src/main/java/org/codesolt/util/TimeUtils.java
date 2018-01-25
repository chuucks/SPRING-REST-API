package org.codesolt.util;

import java.time.Duration;

public class TimeUtils {

	public static String formatDuration(Duration duration) {
		return duration.getSeconds() + "." + duration.getNano() + " s";
	}	
}
