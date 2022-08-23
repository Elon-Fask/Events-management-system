package com.springboot.webapp.model.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.springboot.webapp.model.Activity;

@Entity
@Table(name = "Participant")
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Participant  extends User{
	private static final long serialVersionUID = 1L;

	@Column(name = "Domaine")
	private String Domaine;

	@Column(name = "Structure")
	private String Structure;
	
	@ManyToMany(mappedBy = "participant", fetch = FetchType.EAGER)
	private List<Activity> activite;
}

