package com.example.demo

import org.springframework.stereotype.Service

@Service
class GreetingService
{
    fun greet(name: String): String {
        return "Hello, $name!"
    }

    fun farewell(name: String): String {
        return "Goodbye, $name!"
    }
}