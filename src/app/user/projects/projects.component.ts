import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../../../service/project.service';
import { ProjectDTO } from '../../../dto/projectdto';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {

  projects: ProjectDTO[];
  projecttoinsert: ProjectDTO = new ProjectDTO();
  projectview: ProjectDTO[];
  userid : number;
  
  
  constructor(private service: ProjectService) { }

  ngOnInit() {
    
    this.getProjects();
  
  }

  getProjects() {

    this.getuserid();
    this.projectview=[];
    this.service.getAll().subscribe(projects => 
      {
        this.projects = projects;
        this.projects.forEach((pasquale)=> 
          {
            if (JSON.parse(localStorage.getItem('currentUser')).id==pasquale.userid)
              {
                this.projectview.push(pasquale);
              }
          }
        )
      }
      ) 
      ; 
      
      
    
  }

  delete(project: ProjectDTO) {
    this.service.delete(project.projectid).subscribe(() => this.getProjects());
  }

  update(project: ProjectDTO) {
    this.service.update(project).subscribe(() => this.getProjects());
  }

  insert(project: ProjectDTO) {

    project.projectid = 0;
    project.userid = this.userid;
    this.service.insert(project).subscribe(() => this.getProjects());
    this.clear();

  }

  clear(){
    this.projecttoinsert = new ProjectDTO();
  }

  getuserid(){
    this.userid = JSON.parse(localStorage.getItem('currentUser')).id;
  }
}
