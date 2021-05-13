package infrastructure.service

import application.`interface`.FileReaderInterface
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import domain.model.MockRoute
import java.io.File

object JsonReader: FileReaderInterface {
    override fun readFile(file: File): MockRoute {
        val mapper = jacksonObjectMapper()
        return mapper.readValue(file.readText())
    }

    override fun readPath(path: String): FileTreeWalk {
        return File(path).walk()
    }
}
