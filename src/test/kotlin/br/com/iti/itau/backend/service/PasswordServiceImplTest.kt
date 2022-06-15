package br.com.iti.itau.backend.service

import br.com.iti.itau.backend.core.service.PasswordService
import br.com.iti.itau.backend.core.service.impl.PasswordServiceImpl
import br.com.iti.itau.backend.factory.PasswordFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PasswordServiceImplTest {

    private val factory = PasswordFactory()
    private val useCaseImpl: PasswordService = PasswordServiceImpl()

    @Test
    fun `should return true`() {
        val password = useCaseImpl.execute(factory.createPasswordValid())
        Assertions.assertEquals(true, password.isValid)
    }

    @Test
    fun `should return false - Password With Repeated Character`() {
        val password = useCaseImpl.execute(factory.createPasswordWithRepeatedCharacter())
        Assertions.assertEquals(false, password.isValid)
    }

    @Test
    fun `should return false - Password Blank`() {
        val password = useCaseImpl.execute(factory.createPasswordBlank())
        Assertions.assertEquals(false, password.isValid)
    }

    @Test
    fun `should return false - Password With Length Invalid`() {
        val password = useCaseImpl.execute(factory.createPasswordWithLengthInvalid())
        Assertions.assertEquals(false, password.isValid)
    }

}