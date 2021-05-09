package infrastructure

import application.factory.MockFactory
import infrastructure.service.ConfigLoader
import infrastructure.service.JsonReader
import infrastructure.service.generator
import io.ktor.application.*
import io.ktor.routing.*

fun Application.mainModule() {

    routing {
        trace {
            application.log.debug(it.buildText())
        }
        val configLoader = ConfigLoader(
            MockFactory(
                System.getenv("MOCK_PATH"),
                JsonReader
            )
        )
        generator(
            configLoader.get()
        )
    }
}
