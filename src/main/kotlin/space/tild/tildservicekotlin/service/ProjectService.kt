package space.tild.tildservicekotlin.service

import org.springframework.stereotype.Service
import space.tild.tildservicekotlin.database.Project
import space.tild.tildservicekotlin.models.ProjectDto
import space.tild.tildservicekotlin.repository.ProjectRepository

@Service
class ProjectService(
    private val projectRepository: ProjectRepository
) {
    fun addProject(projectDto : ProjectDto) : Project{
        val project = Project(projectName = projectDto.name, projectDescription = projectDto.description)
        return projectRepository.save(project)
    }
}