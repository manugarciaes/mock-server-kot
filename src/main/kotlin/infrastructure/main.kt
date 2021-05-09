import infrastructure.mainModule
import io.ktor.application.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    val port = System.getenv("MOCK_PORT")
    val host = System.getenv("MOCK_HOST")

    embeddedServer(Netty, port = port.toInt(), host = host, module = Application::mainModule).start(wait = true)
}
