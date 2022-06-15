package br.com.iti.itau.backend.integration

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.util.AssertionErrors.assertFalse
import org.springframework.test.util.AssertionErrors.assertTrue
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
properties = ["spring.profile.active=test"])
class PasswordControllerTest {

    @Autowired
    private lateinit var webApplicationContext: WebApplicationContext
    private lateinit var mockMvc: MockMvc

    companion object {
        private const val PATH = "/v1/validate/password"
    }

    @BeforeEach
    fun setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
    }

    @Test
    fun `should return http status 400`() {
        mockMvc.get(PATH).andExpect { status { is4xxClientError() } }
    }

    @Test
    fun `should return true`() {
        val password = "AbTp9!fok"

        val response = mockMvc.get("$PATH?password=$password")
            .andExpect { status { isOk() } }.andReturn().response.contentAsString

        assertTrue(response, true)
    }

    @Test
    fun `should return false`() {
        val password = "AbTp9!foA"

        val response = mockMvc.get("$PATH?password=$password")
            .andExpect { status { isOk() } }.andReturn().response.contentAsString
        assertFalse(response, false)
    }
}