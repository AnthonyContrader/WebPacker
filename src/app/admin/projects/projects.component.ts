import { Component, OnInit } from '@angular/core';
import { ProjectService } from 'src/service/project.service';
import { ProjectDTO } from 'src/dto/projectdto';
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
    this.service.insert(project).subscribe(() => this.getProject());
  }

  clear(){
    this.projectinsert = new ProjectDTO();
  }
}
