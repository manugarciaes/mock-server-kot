package infrastructure.service

import domain.`interface`.FileReaderInterface
import domain.exception.FilesNotFoundException
import java.io.File

class FileReader(private val path: String): FileReaderInterface {
    override fun readPath(): List<File> {
        return File(path).walk().ifEmpty { throw FilesNotFoundException() }.toList()
    }
}
