package space.tild.tildservicekotlin.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class GreetingController {

    @PostMapping("/hello")
    fun hello(@RequestBody name: String) : ResponseEntity<String> {
        return ResponseEntity("Hello ${name}!", HttpStatus.I_AM_A_TEAPOT);
    }
}