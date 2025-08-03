package com.example.demo

import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import com.example.demo.GreetingEntity
import com.example.demo.GreetingRepository
import org.springframework.web.server.ResponseStatusException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.data.web.PageableDefault

@RestController
class HelloController(
    private val repo: GreetingRepository
) {

    @GetMapping("/")
    fun hello(): String {
        return "Hello from Spring Boot bite efe+ Kotlin!"
    }

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Long): GreetingEntity =
    repo.findById(id).orElseThrow {
        ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found")
    }

    @PostMapping("/create-greeting")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody name: String): GreetingEntity {
        val entity = GreetingEntity(message = "Hello $name")
        return repo.save(entity)
    }

    @GetMapping("/greetings")
    fun findAll(
        @PageableDefault(size = 5) pageable: Pageable
    ): Page<GreetingEntity> {
        return repo.customFindAll(pageable)
    }
}