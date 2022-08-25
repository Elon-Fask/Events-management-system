package com.springboot.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "exercise")
@Data
@NoArgsConstructor
public class Exercise implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = "year")
	private int year;
	
	@NotBlank
	@Column(name = "start_date")
	private Date startDate;
	
	@NotBlank
	@Column(name = "end_date")
	private Date endDate;
	
	@NotBlank
	@Column(name= "state")
	private String state;
	
	@OneToMany(mappedBy = "exercise")
	private List<Activity> activity;
	
	
	
	

}
