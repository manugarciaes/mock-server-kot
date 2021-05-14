package domain.`interface`

import domain.model.Route
import java.io.File

interface RouteMapperInterface {
    fun map(file: File): Route?
}
