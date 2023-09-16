package space.tild.tildservicekotlin.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import space.tild.tildservicekotlin.models.ProjectDto
import space.tild.tildservicekotlin.service.ProjectService

@RestController
@RequestMapping("/project")
class ProjectController(private val projectService: ProjectService) {

    @PostMapping("/add")
    fun addProject(@RequestBody projectDto: ProjectDto) = projectService.addProject(projectDto)

}