package org.codesolt.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class Response {
		
	private String duration;
	private Boolean success;
	private String error;
	private String messagge;
}
