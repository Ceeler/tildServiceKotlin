package space.tild.tildservicekotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import space.tild.tildservicekotlin.models.UserDto
import space.tild.tildservicekotlin.service.UserService


@RestController
@RequestMapping("/user")
class UserController (
    var userService: UserService
        ){

    @PostMapping("/signup")
    fun userSignup(@RequestBody userDto : UserDto) = userService.userSignup(userDto)

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id : Long) = userService.getUserById(id)
}