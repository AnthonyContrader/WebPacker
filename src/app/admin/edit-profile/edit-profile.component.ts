import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserDTO } from 'src/dto/userdto';
import { ProjectService } from 'src/service/project.service';
import { UserService } from 'src/service/user.service';
import { UserDataDTO } from 'src/dto/userdatadto';
import { UserDataService } from 'src/service/userdata.service';


@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {

  user: UserDTO;
  userdata: UserDataDTO = new UserDataDTO();
  yesprojects: boolean = false;
  userdatas: UserDataDTO[];
  yesdata: boolean = false;

  constructor(private service: UserService, private psget: ProjectService,
    private psdelete: ProjectService, private router: Router,
    private servicedata: UserDataService, private dataup: UserDataService, private datain: UserDataService) {

  }

  ngOnInit() {
console.log("prima" + this.userdata);
    this.getuser();
    console.log("dopo" + this.userdata);

  }


  update(user: UserDTO, userdata: UserDataDTO) {

    localStorage.setItem('currentUser', JSON.stringify(user));
    userdata.userid = this.user.id;
    localStorage.setItem('currentUserData', JSON.stringify(userdata));
    this.readData(user, userdata)
    this.service.update(user).subscribe(() => this.getuser());
    console.log("getusfatta" + this.userdata);
    //window.location.reload();

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



  getuser() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    if( JSON.parse(localStorage.getItem('currentUserData')) != null)
   this.userdata = JSON.parse(localStorage.getItem('currentUserData'));  
    
    
  }

  deleteAll(user: UserDTO) {

    this.psget.getAll().subscribe(projects => {

      projects.forEach(p => {

        if (user.id == p.userid) {
          if (this.yesprojects == false) {
            this.yesprojects = true;
          }
          this.psdelete.delete(p.projectid).subscribe();
        }
      }
      )
    },
      undefined, () => {
        if (this.yesprojects == true) {

          this.service.delete(user.id).subscribe(() => {

            this.router.navigate(['/login']);
          });
          alert("Utente cancellato, tornerai alla pagina di Login");
          this.yesprojects = false;
        }
      });
  }


}
