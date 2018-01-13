package org.codesolt.model;

import org.joda.time.Period;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class Response {
		
	private Period period;
	private Boolean success;
	private String messagge;
	private String error;	
}
