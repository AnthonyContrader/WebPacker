import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserRoutingModule } from './user-routing.module';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { ProjectsComponent } from './projects/projects.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { GeneralInfoComponent } from './general-info/general-info.component';

/**
 * Modulo dell'user, qui vengono dichiarate le component che utilizza 
 * l'user. Questo modulo importa UserRoutingModule.
 **/

@NgModule({
    declarations: [UserDashboardComponent,ProjectsComponent, EditProfileComponent, GeneralInfoComponent],
    imports: [
      CommonModule,
      UserRoutingModule,
      FormsModule
    ]
  })
  export class UserModule { }