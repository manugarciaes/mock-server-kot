package infrastructure

import io.ktor.application.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    val port = System.getenv("MOCK_PORT") ?: "8080"
    val host = System.getenv("MOCK_HOST") ?: "localhost"

    embeddedServer(Netty, port = port.toInt(), host = host, module = Application::main).start(wait = true)
}
