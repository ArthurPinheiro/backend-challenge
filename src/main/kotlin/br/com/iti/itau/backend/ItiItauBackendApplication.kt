package br.com.iti.itau.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
	scanBasePackages = ["br.com.iti.itau.backend"]
)
class ItiItauBackendApplication

fun main(args: Array<String>) {
	runApplication<ItiItauBackendApplication>(*args)
}
