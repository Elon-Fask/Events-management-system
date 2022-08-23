package com.springboot.webapp.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.webapp.model.role.Role;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="User")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@Column(name = "Nom")
	private String Nom;

	@Column(name = "Prenom")
	private String Prenom;

	@Column(name = "Login")
	private String Login;

	
	@NotBlank
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Size(max = 16)
	@Column(name = "Pa$$word")
	private String Pa$$word;

	@Column(name = "Email")
	private String Email;

	@Column(name = "Telephone")
	private String Telephone;
	
	@ManyToOne
	@JoinColumn(name = "ID_Role")
	private Role role;

}

	