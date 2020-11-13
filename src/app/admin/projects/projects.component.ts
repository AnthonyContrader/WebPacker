import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../../../service/project.service';
import { ProjectDTO } from '../../../dto/projectdto';
import { projection } from '@angular/core/src/render3';
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
  
})
export class ProjectsComponent implements OnInit {

  projects: ProjectDTO[];
  projectinsert: ProjectDTO = new ProjectDTO();
  projectview: ProjectDTO[];
  confronto: string;
  userid : number;

  constructor(private router: Router, private service: ProjectService,private route: ActivatedRoute)
  {
    this.router.routeReuseStrategy.shouldReuseRoute = function()
    {return false ;}
  }
  

  ngOnInit() 
  {
    this.route.queryParams
    .subscribe(params =>{this.confronto=params["ciao"]});
    this.getProject();
  }

  getProject() 
  {
    this.getuserid();
    this.projectview=[];
    
    this.service.getAll().subscribe(projects => 
  {
    this.projects = projects;
    this.projects.forEach((pasquale)=> 
      {
        if (JSON.parse(localStorage.getItem('currentUser')).id==pasquale.userid || this.confronto)
          {
            this.projectview.push(pasquale);
          }
      }
    )
  }
  ) ;
      
  }

  delete(project: ProjectDTO) {
    this.service.delete(project.projectid).subscribe(() => this.getProject());
  }

  update(project: ProjectDTO) {
    this.service.update(project).subscribe(() => this.getProject());
  }

  insert(project: ProjectDTO) {
    project.projectid = 0;
    project.userid = this.userid;
    this.service.insert(project).subscribe(() => this.getProject());
    this.clear();
  }

  clear(){
    this.projectinsert = new ProjectDTO();
  }

  getuserid(){
    this.userid = JSON.parse(localStorage.getItem('currentUser')).id;
  }
}
