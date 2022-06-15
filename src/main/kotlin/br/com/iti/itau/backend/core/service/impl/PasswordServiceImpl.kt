package br.com.iti.itau.backend.core.service.impl

import br.com.iti.itau.backend.core.model.Password
import br.com.iti.itau.backend.core.service.PasswordService
import br.com.iti.itau.backend.infrastructure.model.PasswordResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.regex.Matcher
import java.util.regex.Pattern

@Service
class PasswordServiceImpl(
) : PasswordService {


    companion object{
        private val passwordPattern: String = "^(?=.*[0-9])(?!.*(.).*\\1.*)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-+])(?=\\S+$).{9,20}$"
    }

    override fun execute(password: Password): PasswordResponse {
        val isValid = isValidPassword(password)

        return PasswordResponse(
            isValid = isValid
        )
    }

    private fun isValidPassword(password: Password): Boolean {
        val pattern = Pattern.compile(passwordPattern)
        val matcher: Matcher = pattern.matcher(password.password)

        return if (password.password.isEmpty()) false else matcher.matches()
    }
}