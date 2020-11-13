import { Component, OnInit } from '@angular/core';
import { UserDTO } from '../../../dto/userdto';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  user: UserDTO = new UserDTO;
  constructor() { }

  ngOnInit() {
    //this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.getuser();
  }

  getuser(){
    this.user = JSON.parse(localStorage.getItem('currentUser'));
  }

}
