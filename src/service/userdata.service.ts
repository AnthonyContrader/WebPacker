import { Injectable } from '@angular/core';
import {AbstractService} from './abstractservice';
import { UserDataDTO } from 'src/dto/userdatadto';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserDataService extends  AbstractService<UserDataDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'userdata';
  }
}
