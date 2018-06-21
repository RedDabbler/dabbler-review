/**
  * 闭包
  * 函数字面量在运行时创建的函数值（对象）被称为闭包：closure
  * 任何带有自由变量的函数字面量，都是开放项，因此
  *
  * 函数值是关闭开放项的行动的最终产物
  *
  * x变量是绑定变量
  * more 是自由变量
  */
var more=1
val addMore = (x:Int)=>x+more
addMore(1)
more=99
addMore(1)
// 闭包对捕获变量作出的改变在闭包之外也可见

var someNumers = List(-1,-2,2,1)
var sum =0
someNumers.foreach(sum+=_)
//变量sum处于函数变量sum+=_的外围，尽管这是在运行期改变sum的闭包，但是结果在闭包之外可见
sum

/**
  * 创建和返回 闭包的函数
  * 每次函数被调用都会创建一个新闭包，每个闭包都会返回闭包创建是活跃的more变量
  * @param more
  * @return
  */
def makeIncrease(more:Int) = (x:Int)=>x+more
//捕获值1当作more的绑定的闭包被擦行间被返回
val inc1 = makeIncrease(1)
val inc99 = makeIncrease(99)
//捕获的参数存在于堆中，而不是堆栈中
inc1(10)  //  11
inc99(10)  // 109
