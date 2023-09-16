package space.tild.tildservicekotlin.repository

import org.springframework.data.repository.CrudRepository
import space.tild.tildservicekotlin.database.Project

interface ProjectRepository : CrudRepository<Project, Long>