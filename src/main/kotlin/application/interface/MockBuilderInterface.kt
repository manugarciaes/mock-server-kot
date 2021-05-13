package application.`interface`

import domain.model.MockRoute

interface MockBuilderInterface {
    operator fun invoke(): List<MockRoute>
}
