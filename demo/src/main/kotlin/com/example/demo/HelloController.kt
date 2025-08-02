package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

data class Greeting(val message: String)

@RestController
class HelloController {

    @GetMapping("/")
    fun hello(): String {
        return "Hello from Spring Boot bite efe+ Kotlin!"
    }

    @GetMapping("/greet/{name}")
    fun greet(@PathVariable name: String): Greeting {
        return Greeting(message = "Hello, $name!")
    }
}