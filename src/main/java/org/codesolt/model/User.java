package org.codesolt.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;

@ToString
@AllArgsConstructor
public class User {
	
	@NotNull
	@Getter @Setter
	private String userName;
	
	@Getter @Setter
	private String role;
}
