package com.example.demo

import jakarta.persistence.*

@Entity
@Table(name = "greetings")
data class GreetingEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val message: String

) {
    protected constructor() : this(0, "")
}
