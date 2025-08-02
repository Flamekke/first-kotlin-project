package com.example.demo

import com.example.demo.GreetingEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GreetingRepository : JpaRepository<GreetingEntity, Long>