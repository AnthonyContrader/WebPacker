package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import it.contrader.model.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO della classe Project. Ha gli stessi attributi di Project
 * 
 * @author Crapara Team
 * 
 *@see Project
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="projectid")
public class ProjectDTO {

	private Long projectid;

	private Long userid;

	private String projectname;


}