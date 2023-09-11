package space.tild.tildservicekotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TildServiceKotlinApplication

fun main(args: Array<String>) {
    runApplication<TildServiceKotlinApplication>(*args)
}
