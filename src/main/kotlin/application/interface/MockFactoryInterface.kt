package application.`interface`

import domain.Mock

interface MockFactoryInterface {
    operator fun invoke(): List<Mock>
}
