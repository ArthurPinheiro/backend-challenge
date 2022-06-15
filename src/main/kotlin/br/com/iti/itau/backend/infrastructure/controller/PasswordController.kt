package br.com.iti.itau.backend.infrastructure.controller

import br.com.iti.itau.backend.infrastructure.model.PasswordRequest
import br.com.iti.itau.backend.core.service.PasswordService
import br.com.iti.itau.backend.infrastructure.converter.PasswordConverter
import br.com.iti.itau.backend.infrastructure.model.PasswordResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/validate")
class PasswordController(
    private val validPasswordUseCase: PasswordService,
    private val converter: PasswordConverter
) {

    @GetMapping("/password")
    @ResponseStatus(HttpStatus.OK)
    fun validPassword(
        @RequestParam("password", required = true) password: PasswordRequest
    ): PasswordResponse {
        val converterPassword = converter.toUseCase(password)
        return validPasswordUseCase.execute(password = converterPassword)
    }

}