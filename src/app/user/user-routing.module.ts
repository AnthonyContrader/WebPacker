import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserLayoutComponent } from '../layout/user-layout/user-layout.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { ProjectsComponent } from './projects/projects.component';
import { EditProfileComponent } from '../user/edit-profile/edit-profile.component';
import { GeneralInfoComponent } from './general-info/general-info.component';

const routes: Routes = [
    { path: 'user-dashboard', component: UserLayoutComponent, children:[
      { path: '', component: UserDashboardComponent},
      { path: 'projects', component: ProjectsComponent},
      {path: 'edit-profile', component : EditProfileComponent},
      {path: 'general-info', component: GeneralInfoComponent}
      
    ]}
  ];

  @NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })
  export class UserRoutingModule { }