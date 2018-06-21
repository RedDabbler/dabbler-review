package com.dabbler.scala.classdemo

import SingletonDemo.calculate
//scala的每个源文件都隐含了java.lang，包scala，以及单例对象Predef的成员引用
//比如println 语句，实际调用的Predef的println（Predef.println转为调用Console.println）
// assert 实际调用Perdef.assert
object Summer {
  def main(args: Array[String]): Unit = {
    for (arg<-args){
      println(arg+":"+calculate(arg))
    }
  }
}

// scala对源文件的命名没有硬性规定，
// 而通常情况下，如果不是脚本，推荐的风格是像在java里那样按照包含的类型来命名文件
// 脚本必须以结果表达式结束，因此尝试以脚本方式执行Summer.scala，scala解释器将会报错，说Summer.scala不是以结果表达式结束
