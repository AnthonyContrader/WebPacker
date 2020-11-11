package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.UserDataDTO;
import it.contrader.model.UserData;

/**
 * Questa classe implementa i metodi di conversione dell'entità UserData.
 *  
 * @author Crapara Team
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class UserDataConverter extends AbstractConverter<UserData,UserDataDTO> {
	
	@Override
	public UserData toEntity(UserDataDTO userdataDTO) {
		UserData userdata = null;
		if (userdataDTO != null) {
			userdata = new UserData(
					userdataDTO.getUserid(),userdataDTO.getFirstname(),userdataDTO.getLastname(),
					userdataDTO.getTelephone(),userdataDTO.getEmail(),userdataDTO.getNationality()
					);			
		}
		return userdata;
	}

	@Override
	public UserDataDTO toDTO(UserData userdata) {
		UserDataDTO userdataDTO = null;
		if (userdata != null) {
			userdataDTO = new UserDataDTO(
					userdata.getUserid(),userdata.getFirstname(),userdata.getLastname(),
					userdata.getTelephone(),userdata.getEmail(),userdata.getNazionality()
					);
			
		}
		return userdataDTO;
	}

}
