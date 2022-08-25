package com.springboot.model.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.model.role.Role;
import com.springboot.model.audit.DateAudit;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NaturalId;

import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"}),
		@UniqueConstraint(columnNames = {"email"})})
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class User extends DateAudit {
	private static final long serialVersionUID = 1L;
	
	@Id 
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank
	@Column(name = "first_name")
	@Size(max = 40)
	private String firstName;
	
	@NotBlank
	@Column(name = "last_name")
	@Size(max = 40)
	private String lastName;

	@NotBlank
	@Column(name = "username")
	@Size(max = 15)
	private String username;
	
	@NotBlank
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Size(max = 100)
	@Column(name = "pa$$word")
	private String pa$$word;
	
	@NotBlank
	@NaturalId
	@Size(max = 40)
	@Column(name = "email")
	@Email
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private List<Role> roles;
	
	
	
	
	
}
