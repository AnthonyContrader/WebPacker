

package it.contrader.model;

import javax.persistence.Entity;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Model dell'entità Project.
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see ProjectDTO
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Project {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long projectid;
	
	@Column(unique = true)
	
	private long userid;
	
	private String projectname;
	
}
