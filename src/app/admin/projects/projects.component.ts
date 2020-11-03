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
  projectinsert: ProjectDTO = new ProjectDTO();

  constructor(private service: ProjectService) { }

  ngOnInit() {
    this.getProject();
  }

  getProject() {
    this.service.getAll().subscribe(projects => this.projects = projects);
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
