package space.tild.tildservicekotlin.repository

import org.springframework.data.repository.CrudRepository
import space.tild.tildservicekotlin.database.DirectMessage
import space.tild.tildservicekotlin.database.ProjectMessage

interface DirectMessageRepository : CrudRepository <DirectMessage, Long>

interface ProjectMessageRepository : CrudRepository<ProjectMessage, Long>