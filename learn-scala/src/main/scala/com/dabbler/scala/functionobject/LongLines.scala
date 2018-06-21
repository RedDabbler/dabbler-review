package com.dabbler.scala.functionobject

import scala.io.Source

object LongLines {
  /**
    * 本地函数
    * 把processLine转为局部方法processFile
    * 本地函数processLine仅用于方法processFile内，外部无法访问
    */
  def processFile(fileName: String, width: Int): Unit = {
      def processLine(filenName: String, width: Int, line: String): Unit = {
        if (line.length > width)
          println(fileName + ":" + line)
      }

    val source = Source.fromFile(fileName)
    for (line <- source.getLines) {
      processLine(fileName, width, line)
    }
  }

  /**
    * 改善
    * 本地函数可以访问包含其函数的参数，因此 可以省略入参 fileName,width
    * @param fileName
    * @param width
    */
  def processFile1(fileName: String, width: Int): Unit = {
    def processLine(line: String): Unit = {
      if (line.length > width)
        println(fileName + ":" + line)
    }
    val source = Source.fromFile(fileName)
    for (line <- source.getLines) {
      processLine1(line)
    }
  }
}
