package infrastructure.service

import application.`interface`.MockFactoryInterface
import domain.Mock

class ConfigLoader(private val mockFactory: MockFactoryInterface) {
    fun get(): List<Mock> {
        return mockFactory()
    }
}
