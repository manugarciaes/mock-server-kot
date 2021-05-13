package application.factory

import application.`interface`.FileReaderInterface
import application.`interface`.MockBuilderInterface
import domain.model.MockRoute

class MockBuilder(private val path: String, private val fileReader: FileReaderInterface): MockBuilderInterface {

    override operator fun invoke(): List<MockRoute> {
        return loadFiles()
    }

    private fun loadFiles(): List<MockRoute> {
        val mutableList = mutableListOf<MockRoute>()
        fileReader.readPath(path).forEach {
            if (it.isDirectory) {
                return@forEach
            }
            val mock = fileReader.readFile(it)
            mutableList.add(mock)
        }
        return mutableList.toList()
    }
}
