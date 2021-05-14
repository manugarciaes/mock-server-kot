package domain.`interface`

import domain.model.Route

interface RouteListBuilderInterface {
    operator fun invoke(): List<Route>
}
