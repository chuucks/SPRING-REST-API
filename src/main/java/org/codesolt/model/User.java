package org.codesolt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
	
	@Id
	private Integer id;
	
	@NotNull
	private String userName;

	@NotNull
	private String password;
	
	@NotNull
	private String role;
	
	@NotNull
	private Integer active;
	
	@Column(name="CREATE_TS", updatable = false)
	private Date createTs;
	
	@Column(name="LAST_UPDT_TS")
	private Date lastUpdtTs;
	
	@PrePersist
	private void intialTs() {
		this.createTs = new Date();
		this.lastUpdtTs = new Date();
	}
	
	@PreUpdate
	private void updateTs() {
		this.lastUpdtTs = new Date();
	}
}
