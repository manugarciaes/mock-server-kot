package infrastructure

import application.factory.MockBuilder
import infrastructure.service.ConfigLoader
import infrastructure.service.JsonReader
import infrastructure.service.generator
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.routing.*

fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)
    routing {
        trace {
            application.log.debug(it.buildText())
        }
        val configLoader = ConfigLoader(
            MockBuilder(
                System.getenv("MOCK_PATH") ?: "config/mocks",
                JsonReader
            )
        )

        generator(
            configLoader.get()
        )
    }
}
