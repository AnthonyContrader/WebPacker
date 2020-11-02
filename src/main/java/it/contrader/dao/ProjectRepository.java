package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Project;


/**
 * Estende CrudRepository ed eredita tutti i metodi di CRUD. 
 * 
 * @author Crapara Team
 *
 * @see CrudRepository
 *
 */
@Repository
@Transactional
public interface ProjectRepository extends CrudRepository<Project, Long>{

	Project findByProjectid(Long projectid);
	
}
