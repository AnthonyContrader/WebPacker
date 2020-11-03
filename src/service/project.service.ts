import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ProjectDTO } from 'src/dto/projectdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Crapara team
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class ProjectService extends AbstractService<ProjectDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'project';
  }

  login(loginDTO: LoginDTO): Observable<ProjectDTO> {
    return this.http.post<any>('http://localhost:8080/' + this.type + '/login', loginDTO)
  }

}
