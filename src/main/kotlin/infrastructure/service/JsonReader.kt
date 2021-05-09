package infrastructure.service

import application.`interface`.JsonReaderInterface
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import domain.Mock
import java.io.File

object JsonReader: JsonReaderInterface {
    override fun read(file: File): Mock {
        val mapper = jacksonObjectMapper()
        return mapper.readValue(file.readText())
    }
}
