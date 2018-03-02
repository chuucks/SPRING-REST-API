package org.codesolt.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Response {

	@NonNull private Integer results;
	@NonNull private String duration;
	@NonNull private Boolean success;
	private String error;
}
