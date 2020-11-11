package it.contrader.service;

import org.springframework.stereotype.Service;
import it.contrader.dao.UserDataRepository;
import it.contrader.dto.UserDataDTO;
import it.contrader.model.UserData;

/**
 * Estende AbstractService con parametri UserData e UserDataDTO. 
 * Implementa il metodo di ricerca ed eredita quelli Abstract. 
 * 
 * @author Crapare Team
 * 
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class UserDataService extends AbstractService<UserData,UserDataDTO> {

	
	public UserDataDTO findByUserId(Long id) {
		return converter.toDTO(((UserDataRepository)repository).findByUserid(id));
	}
}
