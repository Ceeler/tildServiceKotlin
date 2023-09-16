package space.tild.tildservicekotlin.repository

import org.springframework.data.repository.CrudRepository
import space.tild.tildservicekotlin.database.Task

interface TaskRepository : CrudRepository<Task, Long>