import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router';
import { ProjectService } from 'src/service/project.service';
import { UserDataDTO } from 'src/dto/userdatadto';
import { UserDataService } from 'src/service/userdata.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {

  user : UserDTO;
  userdata: UserDataDTO = new UserDataDTO();
  userdatas: UserDataDTO[];
  yesdata: boolean = false;

  constructor(private service: UserService, private psget : ProjectService, private psdelete: ProjectService,
    private router : Router,private servicedata: UserDataService, 
    private dataup: UserDataService, private datain: UserDataService) { }

  ngOnInit() {
    this.getuser();
  }

  update(user: UserDTO,userdata: UserDataDTO) {

    localStorage.setItem('currentUser', JSON.stringify(user));
    userdata.userid = this.user.id;
    localStorage.setItem('currentUserData', JSON.stringify(userdata))
    this.readData(user, userdata)
    this.service.update(user).subscribe(
      () => this.getuser()
      ,undefined,()=>
      
      alert("Modifiche effettuate")
      );

  }

  readData(user: UserDTO, userdata: UserDataDTO) {

    this.servicedata.getAll().subscribe(datas => {
      datas.forEach(d => {
        if (d.userid == user.id) {
          this.dataup.update(userdata).subscribe();
          this.yesdata = true;
        }
      }
      );
    }, undefined, () => {
      if (this.yesdata == false) {
        this.datain.insert(userdata).subscribe();
      }
      this.yesdata = false;
    }
    )
  }



  delete(user:UserDTO){
    this.deleteAll(user);   
    this.service.delete(user.id).subscribe( () => {
      this.router.navigate(['/login']);
    });
  }
  getuser(){
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    if( JSON.parse(localStorage.getItem('currentUserData')) != null)
    this.userdata = JSON.parse(localStorage.getItem('currentUserData'));
  }

  deleteAll(user: UserDTO){
    this.servicedata.delete(user.id).subscribe();
    this.psget.getAll().subscribe(projects =>{
      projects.forEach(p =>{
        if (user.id == p.userid){
         
          this.psdelete.delete(p.projectid).subscribe();
        }
       }
      )
    },
    undefined, () => {  
        this.service.delete(user.id).subscribe( () => {
          this.router.navigate(['/login']);
        });
        alert("Utente cancellato, tornerai alla pagina di Login");
      
    } );
  }


}
