package br.com.iti.itau.backend.infrastructure.converter.impl

import br.com.iti.itau.backend.core.model.Password
import br.com.iti.itau.backend.infrastructure.converter.PasswordConverter
import br.com.iti.itau.backend.infrastructure.model.PasswordRequest
import org.springframework.stereotype.Component

@Component
class PasswordConverterImpl : PasswordConverter {

    override fun toUseCase(request: PasswordRequest): Password {
        return Password(
            password = request.password
        )
    }
}