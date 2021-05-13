package integration

import com.fasterxml.jackson.databind.ObjectMapper
import infrastructure.main
import io.ktor.application.Application
import io.ktor.http.HttpMethod
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import org.junit.Test
import org.mockito.Mockito.mock
import java.io.File
import kotlin.test.assertEquals

class RoutingTest {

    @Test
    fun validRouteUser() {
        withTestApplication(Application::main) {
            val call = handleRequest(HttpMethod.Get, "/user")

            assertEquals("""
                {
                        "test" : "true"
                }
            """.asJson(), call.response.content?.asJson())
        }
    }
}

fun String.asJson() = ObjectMapper().readTree(this)