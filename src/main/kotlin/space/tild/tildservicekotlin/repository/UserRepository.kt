package space.tild.tildservicekotlin.repository

import org.springframework.data.repository.CrudRepository
import space.tild.tildservicekotlin.database.User

interface UserRepository : CrudRepository<User, Long>