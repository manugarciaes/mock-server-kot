package unit.application

import application.builder.RouteListBuilder
import domain.`interface`.FileReaderInterface
import domain.`interface`.RouteMapperInterface
import domain.model.Header
import domain.model.Request
import domain.model.Response
import domain.model.Route
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.kotlin.anyVararg
import org.mockito.kotlin.mock
import java.io.File
import kotlin.test.assertTrue

class RouteListBuilderTest {

    @Mock
    val mockFile: File? = null

    @Test
    fun buildAValidListOfFiles() {
        val listOfFiles = listOf(mockFile)
        val route = Route(
            Request("", ""),
            Response("", Header(""), "")
        )
        val mockFileReader = mock<FileReaderInterface>()
        val mockRouteMapper = mock<RouteMapperInterface>()

        Mockito.`when`(mockRouteMapper.map(anyVararg())).thenReturn(
            route
        )
        Mockito.`when`(mockFileReader.readPath()).thenReturn(
            listOfFiles as List<File>?
        )

        val routeListBuilder = RouteListBuilder(
            mockFileReader,
            mockRouteMapper
        )

        val response = routeListBuilder()
        assertTrue(response.first() is Route)
    }

    @Test
    fun failsBecauseFilesNotFound() {

    }
}