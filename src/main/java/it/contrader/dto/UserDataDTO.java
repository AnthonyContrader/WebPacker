package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO della classe UserData. Ha gli stessi attributi di UserData
 * 
 * @author Crapara Team
 * 
 *@see UserData
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="userid")
public class UserDataDTO {
	
	private long userid;
	
	private String firstname;
	
	private String lastname;
	
	private long telephone;
	
	private String email;
	
	private String nationality;
	
}
