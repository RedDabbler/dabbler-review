package com.dabbler.scala.functionobject

/**
  * 像操作对象一样操作函数
  * () => Unit ，这个类型便是所有无对象且无返回值函数的类型
  */
object Timer {
  def oncePerSecond(callback: () => Unit) {
    while (true) { callback(); Thread sleep 1000 }
  }

  def timeFlies() {
    println("time flies like an arrow...")
  }
  def main(args: Array[String]) {
    oncePerSecond(timeFlies)
  }
}
