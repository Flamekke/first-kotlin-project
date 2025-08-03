package com.example.demo

import com.example.demo.GreetingEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.data.web.PageableDefault

@Repository
interface GreetingRepository : JpaRepository<GreetingEntity, Long> {
    @Query(
        value = "SELECT * FROM greetings",
        nativeQuery = true
    )
    fun customFindAll(
        @PageableDefault(page = 0, size = 5, sort = ["id"]) pageable: Pageable
    ): Page<GreetingEntity>
}
