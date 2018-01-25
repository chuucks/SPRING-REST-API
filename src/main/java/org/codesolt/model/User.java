package org.codesolt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min=1, max=100)
	private String userName;

	@Email
	@Size(min=1, max=100)
	private String email;
	
	@Size(min=1, max=100)
	private String password;
	
	@Size(min=1, max=100)
	private String role;
	
	@Min(0) @Max(1)
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
