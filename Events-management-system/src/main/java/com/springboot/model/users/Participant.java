package com.springboot.model.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.springboot.model.Activity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "participant")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Participant extends User{
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Column(name = "domaine")
	private String demaine;
	
	@NotBlank
	@Column(name = "structure")
	private String structure;
	
	@ManyToMany(mappedBy = "participant", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Activity> activity;
	
}
