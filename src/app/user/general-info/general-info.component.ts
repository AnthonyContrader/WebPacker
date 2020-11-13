import { Component, OnInit } from '@angular/core';
import { UserDataDTO } from '../../../dto/userdatadto';
import { UserDTO } from '../../../dto/userdto';

@Component({
  selector: 'app-general-info',
  templateUrl: './general-info.component.html',
  styleUrls: ['./general-info.component.css']
})
export class GeneralInfoComponent implements OnInit {

  user : UserDTO;
  userdata : UserDataDTO;
  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    if( JSON.parse(localStorage.getItem('currentUserData')) != null)
    this.userdata = JSON.parse(localStorage.getItem('currentUserData'));  
  }

  

}
