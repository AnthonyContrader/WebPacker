import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router';
import { ProjectService } from 'src/service/project.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {

  user : UserDTO;
  yesprojects: boolean = false;
  constructor(private service: UserService, private psget : ProjectService, private psdelete: ProjectService,private router : Router) { }

  ngOnInit() {
    this.getuser();
  }

  update(user: UserDTO) {

    localStorage.setItem('currentUser', JSON.stringify(user));
    this.service.update(user).subscribe(() => this.getuser());
    window.location.reload();
  }

  delete(user:UserDTO){
    this.deleteAll(user);
    this.service.delete(user.id).subscribe( () => {

      this.router.navigate(['/login']);
    });
  }
  getuser(){
    this.user = JSON.parse(localStorage.getItem('currentUser'));
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
        this.yesprojects = false;
      }
    } );
  }


}
