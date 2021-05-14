package application.builder

import domain.`interface`.FileReaderInterface
import domain.`interface`.RouteListBuilderInterface
import domain.`interface`.RouteMapperInterface
import domain.model.Route

class RouteListBuilder(
    private val fileReader: FileReaderInterface,
    private val mockMapper: RouteMapperInterface
    ): RouteListBuilderInterface {

    override operator fun invoke(): List<Route> {
        return build()
    }

    private fun build(): List<Route> {
        val mutableList = mutableListOf<Route>()
        fileReader.readPath().forEach {
            val mockRoute = mockMapper.map(it);
            if (mockRoute is Route) {
                mutableList.add(mockRoute)
            }
        }
        return mutableList.toList()
    }
}
