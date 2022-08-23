package com.springboot.webapp.model.role;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.springboot.webapp.model.user.User;

@Entity
@Table(name="Role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@Column(name = "Nom")
	private String Nom;
	
	@OneToMany(mappedBy = "role")
	private List<User> user;
}
