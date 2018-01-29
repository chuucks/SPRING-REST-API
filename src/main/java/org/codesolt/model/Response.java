package org.codesolt.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response {

	private Integer results;
	private String duration;
	private Boolean success;
	private String error;
}
