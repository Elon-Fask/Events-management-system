package com.springboot.model.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.springboot.model.Activity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "responsible")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Responsible extends User {
	private static final long serialVersionUID = 1L;

	@Column(name = "domaine")
	private String domaine;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "etat")
	private String etat;
	
	@OneToMany(mappedBy = "responsible")
	private List<Activity> activity;
}
