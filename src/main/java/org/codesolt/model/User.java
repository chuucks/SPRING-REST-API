package org.codesolt.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@RequiredArgsConstructor(staticName="name")
public class User {

	@Getter @Setter
	private String name;
}
