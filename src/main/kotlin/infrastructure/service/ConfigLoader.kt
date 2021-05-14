package infrastructure.service

import domain.`interface`.RouteListBuilderInterface
import domain.model.Route

class ConfigLoader(private val mockBuilder: RouteListBuilderInterface) {
    fun get(): List<Route> {
        return mockBuilder()
    }
}
