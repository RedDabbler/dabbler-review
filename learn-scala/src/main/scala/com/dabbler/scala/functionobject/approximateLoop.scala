package com.dabbler.scala.functionobject

class approximateLoop {

  // 未实现 用??? 代替，否则会变成抽象方法
  def isGoodEnough(guess:Double):Boolean= ???
  def improve(guess: Double): Double= ???



  def approximateLoop(initalGuess:Double):Double={
    var guess = initalGuess
    while (!isGoodEnough(guess))
      guess = improve(guess)
    guess
  }

  // 如果想把更新var的while循环 转换为仅使用val的这种函数式的风格的话，有时可以使用递归
  // 看上去递归调用要更花时间，实际上他们的时间几乎相同
  // 在他们最后一个动作调用自己的函数，称为尾递归
  //    编译器监测到尾递归就用新值更新函数参数，然后把它替换成一个回到函数开头的跳转
  // 递归经常是比基于循环的更优美和简明的方案，如果是尾递归，就无须付出运行期开销

  def approximate(guess:Double):Double=
    if (isGoodEnough(guess))guess
    else approximate(improve(guess))

  /**
    * 尾递归 函数追踪
    */

  //这个不是尾递归，因为递归之后执行了递增操作
  def boom(x:Int):Int =
    if (x==0) throw new Exception("boom!");
    else boom(x-1)+1

  /**
    * 执行结果
    * java.lang.Exception:boom!
    *      at .boom(<console>:5)
    *      at .boom(<console>:6)
    *      at .boom(<console>:6)
    *      at .boom(<console>:6)
    *      at .<init>.boom(<console>:6)
    */
  boom(3)


  //修改变长尾递归
  def bang(x:Int):Int =
    if (x==0) throw new Exception("bang!");
    else boom(x-1)

  /**
    * 执行结果
    java.lang.Exception:bang!
    *      at .boom(<console>:5)
    *      at .<init>.boom(<console>:6)
    *
    *      仅仅看到一个堆栈结构
    *      如果把尾调用的优化开关关掉，即 加上参数 -g:notailcalls
    *      这个参数传给scala后，就能得到上面类似的堆栈跟踪
    *
    *      尾调用优化的代码编译后代码实际上和循环的编译后代码相同
    */
  boom(5)

  /**
    * 尾调用的局限
    * scala仅优化了直接递归调用使其返回同一个函数，如果递归是间接的，就没有优化了
    */

  def isEven(x:Int):Boolean=
    if(x==0) true else isOdd(x-1)

  def isOdd(x: Int):Boolean=
    if (x==0) false else isEven(x-1)

  // 如果最后一个调用时一个函数值 也不能优化尾调用
  /**
    * funValue变量指向一个实质包含了nestedFun的调用的函数值
    * 尾调用仅限于 方法或者嵌套函数必须在最后一个操作调用本身，而不是转为某个函数值或什么其他的中间函数的情况
    */
  val funValue=nestedFun _
  def nestedFun(x:Int): Unit ={
    if(x!=0){
      println(x);
      funValue(x-1)
    }
  }





}
