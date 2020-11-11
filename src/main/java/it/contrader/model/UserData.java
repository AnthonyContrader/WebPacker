package it.contrader.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserData {
	
	@Id
	private long userid;
	
	@Column(unique = true)
	
	private String firstname;
	
	private String lastname;
	
	private long telephone;
	
	private String email;
	
	private String nazionality;

	
}
