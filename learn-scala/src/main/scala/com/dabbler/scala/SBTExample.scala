package com.dabbler.scala


// object name 可以和 文件名称不同
object Main extends App {
  val ages = Seq(42, 75, 29, 64)
  println(s"The oldest person is ${ages.max}")
}