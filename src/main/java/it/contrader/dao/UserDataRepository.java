package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.UserData;

@Repository
@Transactional
public interface UserDataRepository extends CrudRepository<UserData, Long>{

	UserData findByUserid(Long userid);
	
}
