import { Component, OnInit } from '@angular/core';
import { LoginDTO } from 'src/dto/logindto';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router';
import { UserDTO } from 'src/dto/userdto';
import { Usertype } from 'src/dto/usertype';
import {UserDataDTO} from 'src/dto/userdatadto';
import {UserDataService} from 'src/service/userdata.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginDTO: LoginDTO;
  newUser: UserDTO = new UserDTO();
  userdata : UserDataDTO = new UserDataDTO();

  constructor(private service: UserService, private router: Router, private dataservice : UserDataService) { }

  ngOnInit() {
  }

  login(f: NgForm): void {
    this.loginDTO = new LoginDTO(f.value.username, f.value.password);

    this.service.login(this.loginDTO).subscribe((user) => {

      if (user != null) {
        localStorage.setItem('currentUser', JSON.stringify(user));
            this.dataservice.read(user.id).subscribe( (data)=> {
console.log(data);
              if(data != null)
              localStorage.setItem('currentUserData', JSON.stringify(data));


            })
        /*
this.userdata.userid = user.id;
this.userdata.firstname = "ca"
this.userdata.lastname = " po"
this.userdata.telephone = 34
this.userdata.email = "sf"
this.userdata.nationality = "ita"
localStorage.setItem('currentUserData', JSON.stringify(this.userdata));
*/
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
      else{
        alert("Username o password errati, riprova o effettua la registrazione se è la tua prima volta");
      }
    }, undefined);
  }

  signup(f: NgForm): void{
    this.loginDTO = new LoginDTO(f.value.username, f.value.password);

    this.service.login(this.loginDTO).subscribe((user) => {
      if (user == null){
        
        this.newUser.username = this.loginDTO.username;
        this.newUser.password = this.loginDTO.password;
        this.newUser.usertype = Usertype.USER;

        /*
        - Faccio un controllo sull'username
        - Creo una funzione di read nel user.service
        - Creo una funzione di read nell'user controller di spring (METODO GET)
        - Eseguo la read sul database e ritorno un valore String.
        - Se la stringa è nulla, creo effettivamente il mio utente
        - Se la stringa ritorna un valore, non faccio niente, ritorno al login (mando un alert)
        */
localStorage.clear();
        localStorage.setItem('currentUser', JSON.stringify(this.newUser));
        
        this.service.insert(this.newUser).subscribe(()=>{
          alert("Registrazione effettuata, ora puoi effettuare il login");
        });
        
      }
      else{
        alert("Username & password già esistenti");
      }
    });

    
    

  }

}
