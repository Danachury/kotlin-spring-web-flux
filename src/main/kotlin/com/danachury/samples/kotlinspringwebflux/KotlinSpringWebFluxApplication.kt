package com.danachury.samples.kotlinspringwebflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringWebFluxApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringWebFluxApplication>(*args)
}
