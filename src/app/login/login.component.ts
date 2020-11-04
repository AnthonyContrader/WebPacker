import { Component, OnInit } from '@angular/core';
import { LoginDTO } from 'src/dto/logindto';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router';
import { UserDTO } from 'src/dto/userdto';
import { Usertype } from 'src/dto/usertype';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginDTO: LoginDTO;
  newUser: UserDTO = new UserDTO();

  constructor(private service: UserService, private router: Router) { }

  ngOnInit() {
  }

  login(f: NgForm): void {
    this.loginDTO = new LoginDTO(f.value.username, f.value.password);

    this.service.login(this.loginDTO).subscribe((user) => {

      if (user != null) {
        localStorage.setItem('currentUser', JSON.stringify(user));

        switch (user.usertype.toString()) {
          case 'ADMIN': {
            this.router.navigate(['/admin-dashboard']);
            break;
          }
          case 'USER': {
            this.router.navigate(['/user-dashboard']);
            break;
          }
          default:
            this.router.navigate(['/login']);
        }
      }
    }, undefined, ()=>{
      alert("L'UTENTE NON ESISTE, EFFETTUA LA REGISTRAZIONE");
    });
  }

  signup(f: NgForm): void{
    this.loginDTO = new LoginDTO(f.value.username, f.value.password);

    this.service.login(this.loginDTO).subscribe((user) => {
      if (user == null){
        
        this.newUser.username = this.loginDTO.username;
        this.newUser.password = this.loginDTO.password;
        this.newUser.usertype = Usertype.USER;

        localStorage.setItem('currentUser', JSON.stringify(this.newUser));
        
        this.service.insert(this.newUser).subscribe(()=>{
          alert("REGISTRAZIONE EFFETTUATA, ORA FAI IL LOGIN");
        });
        
      }
    });

    
    

  }

}
