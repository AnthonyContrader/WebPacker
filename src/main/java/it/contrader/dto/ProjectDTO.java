package it.contrader.dto;

import it.contrader.model.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProjectDTO {

	private Long projectid;

	private Long userid;

	private String projectname;


}