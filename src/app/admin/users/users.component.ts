import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../service/user.service';
import { UserDTO } from '../../../dto/userdto';
import { ProjectService } from '../../../service/project.service';
import { ProjectDTO } from 'src/dto/projectdto';
import {UserDataDTO} from '../../../dto/userdatadto';
import {UserDataService} from '../../../service/userdata.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  userdata : UserDataDTO = new UserDataDTO();
  users: UserDTO[];
  usertoinsert: UserDTO = new UserDTO();
  yesprojects: boolean = false;
  temp : UserDTO;
  tipoutente : string;

  constructor(private service: UserService, private psget: ProjectService, 
    private psdelete: ProjectService,private servicedata : UserDataService) { }

  ngOnInit() {
    this.getUsers();
  }

  getUsers() {
    
    this.service.getAll().subscribe(users => this.users = users);    
    
  }

  delete(user: UserDTO) {
    this.deleteAll(user);
    this.service.delete(user.id).subscribe(() => this.getUsers());
  }

  update(user: UserDTO) {
    this.service.update(user).subscribe(() => this.getUsers());
  }

  insert(user: UserDTO) {
    
    console.log(this.usertoinsert);
    if( this.tipoutente == "ROLE_ADMIN")
    user.authorities.push("ROLE_USER");
    user.authorities.push(this.tipoutente);
    
    this.service.insert(user).subscribe(() => this.getUsers());
    
    this.clear();
  }
  
  

  clear(){
    this.usertoinsert = new UserDTO();
  }

  deleteAll(user: UserDTO){

    this.psget.getAll().subscribe(projects =>{

      projects.forEach(p =>{

        if (user.id == p.userid){
          if(this.yesprojects == false){
            this.yesprojects = true;
          }
          this.psdelete.delete(p.projectid).subscribe();
        }
       }
      )
    },
    undefined, () => {

      
      if(this.yesprojects == true){
        alert("Progetti utente cancellati, ora puoi cancellare l'utente");
        this.service.delete(user.id).subscribe(() => this.getUsers());
        this.yesprojects = false;
      } else{
        this.service.delete(user.id).subscribe(() => this.getUsers());
      }
    } );
  }

}
