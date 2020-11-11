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
	@Column(unique = true)
	private long userid;
	
	private String firstname;
	private String lastname;
	private long telephone;
	private String email;
	private String nazionality;

	
}
