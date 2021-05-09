package application.factory

import application.`interface`.JsonReaderInterface
import application.`interface`.MockFactoryInterface
import domain.Mock
import java.io.File

class MockFactory(private val path: String, private val jsonReader: JsonReaderInterface): MockFactoryInterface {

    override operator fun invoke(): List<Mock> {
        return loadFiles()
    }

    private fun loadFiles(): List<Mock> {
        val mutableList = mutableListOf<Mock>()

        File(path).walk().forEach {
            if (it.isDirectory) {
                return@forEach
            }
            val mock = jsonReader.read(it)
            mutableList.add(mock)
        }
        return mutableList.toList()
    }
}
