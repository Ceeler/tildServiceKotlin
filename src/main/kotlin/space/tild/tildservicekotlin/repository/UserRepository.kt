package space.tild.tildservicekotlin.database

import org.springframework.data.repository.CrudRepository

//import org.springframework.data.repository.CrudRepository
//import org.springframework.data.repository.reactive.ReactiveCrudRepository
//
//interface UserRepository : ReactiveCrudRepository<User, Long>

interface UserRepository : CrudRepository<User, Long>