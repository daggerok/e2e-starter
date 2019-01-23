package com.github.daggerok

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class E2eTestsApplication

fun main(args: Array<String>) {
  runApplication<E2eTestsApplication>(*args)
}

