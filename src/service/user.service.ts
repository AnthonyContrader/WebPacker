import { Injectable } from '@angular/core';
import { AbstractUService} from './abstractUservice'
import { UserDTO } from 'src/dto/userdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class UserService extends AbstractUService<UserDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type ='users';
   this.port = '8080';
}

auth() {
  const user = JSON.parse(localStorage.getItem('AUTOKEN')) as UserDTO;
  if (user) {
    return 'Bearer ' + user.authorities;
  } else {
    return '';
  }
}

login(loginDTO: LoginDTO): Observable<UserDTO> {
  return this.http.post<any>('http://localhost:8080/api/authenticate', loginDTO);
}

userLogged(username: string) {
 
  console.log(this.auth());
  return this.http.get('http://localhost:8080/api/users/' + username, {
   
  headers: {
      Authorization: this.auth()
    }
  });
}

register(dto: UserDTO): Observable<any> {

  return this.http.post<UserDTO>('http://localhost:8080/api/register',dto, {
  headers: {
    Authorization: this.auth()
  }
});
    
}
  
activate(activationkey : string) {

   return this.http.get('http://localhost:8080/api/activate?key='+activationkey );
      
  }


  
}