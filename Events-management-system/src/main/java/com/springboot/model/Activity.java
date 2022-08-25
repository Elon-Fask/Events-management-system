package com.springboot.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.springboot.model.users.Participant;
import com.springboot.model.users.Responsible;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "activity")
@Data
@NoArgsConstructor
public class Activity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank
	@Size(max = 40)
	@Column(name = "title")
	private String title;
	
	@NotBlank
	@Column(name = "description")
	private String description;
	
	@NotBlank
	@Column(name = "type")
	private String type;
	
	@NotBlank
	@Column(name = "start_date")
	private String StartDate;
	
	@NotBlank
	@Column(name = "end_date")
	private String EndDate;
	
	@NotBlank
	@Column(name = "state")
	private String state;
	
	@ManyToOne
	@JoinColumn(name = "id_Exercise")
	private Exercise exercise;
	
	@ManyToOne
	@JoinColumn(name = "id_user_res")
	private Responsible responsible;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "participant_per_activity",
			joinColumns = @JoinColumn(name = "id_participant"),
			inverseJoinColumns = @JoinColumn(name = "id_activity"))
	private List<Participant> participant;
	
	
	
	
	
	
}
