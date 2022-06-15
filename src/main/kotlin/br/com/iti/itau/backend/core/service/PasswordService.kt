package br.com.iti.itau.backend.core.service

import br.com.iti.itau.backend.core.model.Password
import br.com.iti.itau.backend.infrastructure.model.PasswordResponse

interface PasswordService {

    fun execute(password: Password): PasswordResponse
}