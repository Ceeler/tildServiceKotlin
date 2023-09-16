package space.tild.tildservicekotlin.service

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import space.tild.tildservicekotlin.database.User
import space.tild.tildservicekotlin.repository.UserRepository
import space.tild.tildservicekotlin.models.UserDto

@Service
class UserService(val userRepository: UserRepository) {

    fun userSignup(userDto: UserDto) : ResponseEntity<User> {
        val newUser = User(firstName = userDto.firstName, username = userDto.username, email = userDto.email, password = userDto.password)
        //val createdUser = userRepository.save(newUser).block()
        val createdUser = userRepository.save(newUser)
        return ResponseEntity(createdUser, HttpStatus.CREATED)
    }
    fun getUserById(id : Long) : ResponseEntity<User> {
        val user = userRepository.findById(id)
        return ResponseEntity(user.get(), HttpStatus.OK)
    }
}