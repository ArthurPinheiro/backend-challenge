package br.com.iti.itau.backend.infrastructure.converter

import br.com.iti.itau.backend.core.model.Password
import br.com.iti.itau.backend.infrastructure.model.PasswordRequest

interface PasswordConverter {
    fun toUseCase(request: PasswordRequest): Password
}
