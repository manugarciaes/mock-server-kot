package infrastructure

import application.builder.RouteListBuilder
import infrastructure.service.ConfigLoader
import infrastructure.service.FileReader
import infrastructure.service.JsonFileMapper
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
            RouteListBuilder(
                FileReader(System.getenv("MOCK_PATH") ?: "config/mocks"),
                JsonFileMapper
            )
        )

        generator(
            configLoader.get()
        )
    }
}
