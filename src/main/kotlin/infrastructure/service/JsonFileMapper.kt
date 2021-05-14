package infrastructure.service

import domain.`interface`.RouteMapperInterface
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import domain.model.Route
import java.io.File

object JsonFileMapper: RouteMapperInterface{
    override fun map(file: File): Route? {
        if (file.isDirectory) {
            return null;
        }
        val mapper = jacksonObjectMapper()
        return mapper.readValue(file.readText())
    }
}
