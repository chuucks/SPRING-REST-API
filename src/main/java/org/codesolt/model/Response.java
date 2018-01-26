package org.codesolt.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response {
		
	private String duration;
	private Boolean success;
	private String error;
	private String messagge;
}
