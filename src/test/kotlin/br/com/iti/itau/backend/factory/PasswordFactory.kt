package br.com.iti.itau.backend.factory

import br.com.iti.itau.backend.core.model.Password

class PasswordFactory {


    fun createPasswordValid(): Password {
        return Password(
            password = "AbTp9!fok"
        )
    }

    fun createPasswordWithRepeatedCharacter(): Password {
        return Password(
            password = "AbTp9!fokA"
        )
    }

    fun createPasswordBlank(): Password {
        return Password(
            password = ""
        )
    }

    fun createPasswordWithLengthInvalid(): Password {
        return Password(
            password = "AbT"
        )
    }
}