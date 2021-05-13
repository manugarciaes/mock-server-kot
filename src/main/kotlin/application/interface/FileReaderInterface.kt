package application.`interface`

import domain.model.MockRoute
import java.io.File

interface FileReaderInterface {
    fun readPath(path: String): FileTreeWalk
    fun readFile(file: File): MockRoute
}
