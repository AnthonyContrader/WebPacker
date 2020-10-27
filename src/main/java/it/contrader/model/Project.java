package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectid;

	@Column(unique = true)
	private Long userid;

	private String projectname;
	

}