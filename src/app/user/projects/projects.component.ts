import { Component, OnInit } from '@angular/core';
import { ProjectService } from 'src/service/project.service';
import { ProjectDTO } from 'src/dto/projectdto';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {

  projects: ProjectDTO[];
  projecttoinsert: ProjectDTO = new ProjectDTO();
  constructor(private service: ProjectService) { }

  ngOnInit() {
    this.getProjects();
  }

  getProjects() {
    this.service.getAll().subscribe(projects => this.projects = projects);
    
  }

  delete(project: ProjectDTO) {
    this.service.delete(project.projectid).subscribe(() => this.getProjects());
  }

  update(project: ProjectDTO) {
    this.service.update(project).subscribe(() => this.getProjects());
  }

  insert(project: ProjectDTO) {
    this.service.insert(project).subscribe(() => this.getProjects());
  }

  clear(){
    this.projecttoinsert = new ProjectDTO();
  }
}
