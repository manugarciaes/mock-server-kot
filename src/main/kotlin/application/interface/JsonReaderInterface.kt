package application.`interface`

import domain.Mock
import java.io.File

interface JsonReaderInterface {
    fun read(file: File): Mock
}
