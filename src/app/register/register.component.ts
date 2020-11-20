import { Component, OnInit } from '@angular/core';
import { UserService } from '../../service/user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { UserDTO } from '../../dto/userdto';
import {LoginDTO} from '../../dto/logindto';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private service : UserService, private router: Router) { }

  newutente : UserDTO = new UserDTO();
  loginDTO : LoginDTO;
  passconf : string;
  chiave : string;
  ngOnInit() {
  }

  signup(f : NgForm){

    this.newutente.login = f.value.login;
    this.newutente.email = f.value.email;
    this.newutente.password = f.value.password;
    this.passconf = f.value.passconfirm;

    this.loginDTO = new LoginDTO("admin", "admin")

    this.service.login(this.loginDTO).subscribe((token : any) => {
      
      
      localStorage.setItem("AUTOKEN", JSON.stringify({ "authorities": token.id_token }));
    
        this.service.register(this.newutente).subscribe( (pippo)=> {
      
          this.chiave = pippo.activationKey;
          console.log(this.chiave);
    
         this.prova(this.chiave)
           
        


      });
    },undefined, ()=>{
       localStorage.clear()
       this.router.navigateByUrl('');
    }
       );



   

    

    

  }

  prova(chiave:string){

    this.service.activate(chiave).subscribe();

  }



}
