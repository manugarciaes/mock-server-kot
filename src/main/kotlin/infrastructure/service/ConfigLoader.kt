package infrastructure.service

import application.`interface`.MockBuilderInterface
import domain.model.MockRoute

class ConfigLoader(private val mockBuilder: MockBuilderInterface) {
    fun get(): List<MockRoute> {
        return mockBuilder()
    }
}
