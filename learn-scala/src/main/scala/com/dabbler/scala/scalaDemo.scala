import java.io.{File, FileNotFoundException, FileReader}
import java.net.MalformedURLException

// 语法糖
// 注释：// 和 /*...*/
// 可以直接写，不需要声明
println("hello,world")
println("hello," + args(0))

//--------------
// 类型推断j为Int
var j = 0
// while 和 if后面用括号
while (j < args.length) {
  if (j != 0) {
    print(args(j))
  }
  print(" ")
  // j++, ++j 不起作用
  j += 1
}
println()

/**
  * 函数式编程 几种写法
  */
// 1
args.foreach(arg => print(arg))
println()
//2  函数字面量(x:Int,y:Int)=>x+y
args.foreach((arg: String) => print(arg))
println()
//3 省略
args.foreach(print)
println()

/**
  * for ，下面代码可以读作 "对于args中的arg"，<- 可以认为是"其中"
  */
for (arg <- args) {
  // arg 是val类型，而不是var
  print(arg)
}
println()

/**
  * 用值和类型使对象参数化
  */
// 参数化的意识是在创建实例的同时完成对它的设置，
// 使用值参数化可以通过把值传递给构造器的圆括号来实现
var big = new java.math.BigDecimal("12345")

//通过一个或更多类型指定到基础类型后的方括号来实现
// 如下 字符串数组
val geetingStrings = new Array[String](3)
geetingStrings(0)="hello"
geetingStrings(1)=","
geetingStrings(2)="world"

for(i<- 0 to 2){
  print(geetingStrings(i))
}
println()


/**
  * 方法若只有一个参数，调用的时候可以省略点及括号，
  * 下面的to实际上是仅带有一个Int参数的方法
  * 代码0 to 2 被转换为方法调用 （0).to(2)
  * 这个语法只有在明确指定方法调用的接受者时才有效
  * print如下
  */
Console print 10
println()

// scala 所有的操作符都是方法调用
// + — * / 都可以用来做方法名
/**
  * 1+2  可以写成(1).+(2)
  * 实际是在Int对象1上调用 名为+ 的方法，并把2作为参数传给它
  *
  */

// 数组的转化
// 创造和初始化
var numNames = Array.apply("zero","one","two")
numNames = Array("zero","one","two")
println(Array.apply("zero","one","two"))
// 更新元素
geetingStrings.update(0,"hello")

// 使用list
var oneTwoThree = List(1,2,3)
var oneTwo = List(1,2)
var threeFour=List(3,4)
// 叠加两个列表
var oneTwoThreeFour = oneTwo::: threeFour
println(""+oneTwo+" and "+threeFour)
println(oneTwoThreeFour)

// :: 是右操作数
// 如果方法使用操作数来标注，如a*b ，那么左操作数是方法的调用者，可以改写为a.*(b)
// 除非以方法名以冒号结尾，这种情况下，方法被右操作数调用 因此 1::oneTwo ,::方法的调用者是oneTwo,1是方法的传入参数，因此可以写成 twoThree.::(1)
val oneTwoThree2 = 1::oneTwo
println(oneTwoThree2)

//以Nil作结尾来定义新列表
var oneTwoT = 1::2::3::Nil
println(oneTwoT)

// List没有append操作，随着列表的变长，append的耗时将呈线性增长，而使用:: 做前缀仅消耗固定的时间
// ListBuffer 提供append操作可变列表，完成之后toList
var thrill="will"::"fill"::"until"::Nil
println(thrill(2)) // 返回在thrill列表上索引是2的元素
println(thrill.drop(2)) // 返回去掉前两个元素的thrill列表
println(thrill.dropRight(2)) //返回去掉后两个元素的thrill列表
println(thrill.exists(s=> s=="until"))// 是否有值为util的字符串在thrill里
println(thrill.filter(s=>s.length()==4)) // 返回长度是4的元素依次组成的新列表
println(thrill.forall(s=>s.endsWith("l"))) //判断是否thrill列表里所有元素都是以"l"结尾
println(thrill.foreach(print)) // 打印所有元素
println(thrill.count(s=>s.length==4)) //计算长度为4的元素的个数
println(thrill.mkString(", "))// 返回用列表的元素组成的字符串
println(thrill.head) //列表的第一个元素
println(thrill.tail)
println(thrill.init) // 除最后一个元素意外其他元素组成的列表
println(thrill.isEmpty) // 列表是否为空
println(thrill.last)
println(thrill.length)
println(thrill.map(s=>s+"y")) //列表里的每个String元素添加y构成的列表
// println(thrill.remove(s=>s.length==4)) //返回去除了长度是4的元素后的元素列表
println(thrill.reverse)
thrill="1"::Nil
thrill.apply(0)
println(thrill.apply(0))
println(thrill)
//thrill.sort((s,t)=>s.charAt(0).toLoweCase<t.charAt(0).toLowerCase) // 返回按照第一个字母的字母小写顺序之后的列表
var blist = true::Nil
println(blist)
var alist = thrill::Nil // 列表内放列表
println(alist)
//元组 方法返回多个对象使用
var pair=(99,"Luftballons",1)
println(pair)
println(pair._1) // 索引从1开始
println(pair._2)
// 元组的实际类型取决于它含有的元素数量和这些元素的类型

//set  默认是不可变的Set实例
var jetSet=Set("Boeing","Airbus")
jetSet += "Lear" // 可变和不可变都提供了+方法，可变把元素加入自身，不可变创建并返回
println(jetSet)
println(jetSet.contains("Cess"))

// 要定义可变得
val movieSet = scala.collection.mutable.Set("Hitch","poltergeist")
movieSet+="Shrek"
println(movieSet)

val hashSet = scala.collection.immutable.HashSet("tom","cherry")
println(hashSet+"cor")

var treasureMap = Map[Int,String]()
treasureMap += (1->"go to isLand")
// 1-> "go to isLand" 转换 （1).->("go to isLand")
var romanNum = Map(1->"1",3->"111")

println(romanNum(3)) //根据key获取value
println("---------------------------------------")
// 从代码中去掉var的函数式风格
//def pinrtArgs(args:Array[String]):Unit={
//  var i=0;
//  while(i<args.length){
//    println(args(i))
//    i+=1
//  }
//}
//-------
//def printArgs(args:Array[String]):Unit={
//  for (arg<-args){
//    println(arg)
//  }
//}
//---
def printArgs(args:Array[String]):Unit={
  args.foreach(println)
}
// 上面的代码有副作用  重构后的printArgs并不是纯函数式的，因为它有副作用
// 本例子的副作用是但因到标准输出流
// 识别函数是否有副作用的地方在于 其结果类型是否是Unit。
// 如果某个函数不返回任何有用的值，即返回类型是Unit，那么函数唯一能产生的作用就只能是通过某种副作用
// 函数式方式应该是定义对需要打印的arg进行格式化的方法，不过仅仅返回格式化之后的字符串

def formatArgs(args:Array[String]) = args.mkString("\n")

var res = formatArgs(Array("zero","one"))
assert(res== "zero\none")

// scala程序员的平衡感
// 崇尚val，不可变对象和没有副作用的方法
// 只有在特定需求或者加以权衡才会选择var，可变对象和有副作用的方法

// 代码里没有var。仅仅包含var，那么他或许是函数式风格
// 包含var，可能是指令式风格
println("------------读取文本行---------------------------")
// 从文件里读取文本行
//import scala.io.Source
if (args.length>0){
  for (line<-scala.io.Source.fromFile("MyFirstScala.scala").getLines){
    println(line.length +""+line)
  }
}else{
  Console.err.println("please enter fileName")
}


//特殊语法
// 以同一行里的三个引号（"""）作为开始和结束
println(
  """ welcome to ultamix 3000
      Type "HELP" for help""")
// 打印
// welcome to ultamix 3000
//      Type "HELP" for help
// 原因是第二行前导的空格被包含在字符串中
// 为了解决这个问题，引入stripMargin方法，把官道符号放在每行前面，然后对这个字符串调用stripMargin
println(
  """
    |welcome to ultamix 3000
    |Type "HELP" for help
  """.stripMargin)

// 输出结果

// welcome to ultamix 3000
// Type "HELP" for help

// 符号字面量
def updateRecord(r:Symbol,value:Any): Unit ={
  //
}
// '<标识符> 标识符不能以数字开头
// 符号字面量被映射为预定义类scala.Symbol的实例
// 符号字面量除了显示名字，什么都不能做
//如果同一个符号字面量出现两次，那么两个字面量指向的是同一个Symbol对象

var s='fdsf
s.name

// 任何方法都可以是操作符
// 前缀标注和后缀标注
// 前缀标注 方法名被放在调用对象的前面 如 -7 里的-
// 后缀标注 方法放在对象的后面， 如 7 toLong的 toLong


// -2 实际是调用了（2).unary_-
// 前缀操作符 简写形式，方法名加前缀 'unary_'
// 前缀操作符 有 + - ！~
// !p  实际上是 p.unary_!

// 即时定义了名为unary_*的方法，也没把*用成前缀操作符

// 后缀操作符 是不用 点或括号 调用的不带任何参数的方法
// 方法调用的空括号可以省略，若果方法有副作用，就加上括号如println()
var sr ="hello"
sr.toLowerCase
sr toLowerCase

//<< 左移 >> 右移 >>> 无符号右移

/**
  * == 和java的== 不同
  * 比较两个变量是否指向JVM堆里的同一个对象 ，名字是eq
  */
List(1,2,3)=List(1,2,3) //true
1==1.0 // true


/**
  * 操作符优先级
  */

2<< 2+2 // 值是32 << 开始于字符<, 比+方法的优先级要低
//a:::b 等价于  b.:::(a)

/**
  * 富包装器
  * implicit conversion 隐式转换
  */
0 max 5  // scala.runtime.RichByte /RichInt
4 to 6 // 结果Range(4,5,6)
"bob" capitalize //首字母大写
1.5 isInfinite


// while 和do-while 不是表达式，如果对某个while或do循环没有费用不可的理由，建议其他方式

1 to 5 // 可很方便的创建Range

for(i<- 1 to 5){
  println(i)
}
// 不包含Range的上边界  索引应该从0还是1开始，容易出错
for(i<- 1 until 5){
  println(i)
}

/**
  * for 表达式添加过滤器 即 if子句，实现过滤, if子句必须用分号分割
  */
val filesHere = new File((".")).listFiles()

for(file <- filesHere
  if file.isFile;
  if file.getName.endsWith(".scala")
)println(file)

def fileLines(file:java.io.File)=scala.io.Source.fromFile(file).getLines().toList
//def grep(pattern:String) = {
//  for {
//    file <- filesHere
//    if file.getName.endsWith(".scala")
//    line <- fileLines(file)
//    trimmed = line.trim
//    if trimmed match (pattern)
//  } println(file+":"+trimmed)
//
//}
/**
  * 制造新集合
  * for{子句}yield{循环体}
  */
def scalaFiles =
for{ file<-filesHere
 if file.getName.endsWith(".scala")
}yield file

/**
  * 异常处理
  */
try {
  val f = new FileReader("input.txt")
}catch {
  case ex:FileNotFoundException=> //处理丢失的文件
  case ex:java.io.IOException => // 处理IO错误
}finally{
  f = null;
}

// 异常返回值
def urlFor(path:String)=
  try{
    new java.net.URL(path)
  }catch {
    case e:MalformedURLException=>new java.net.URL("http://www.scala-lang.org")
  }

/**
  * 匹配表达式
  * scala的match 表达式 类似于java的swith语句，它可以提供给你在多个备选项中做选择
  */

var firstArg = if (args.length>0) args(0) else ""
firstArg matches{
  case "salt" => println("perper")
  case "chips" =>println("scala")
  case _ => println("huh?")// 默认情况用下划线表示

}
/**
  * 赋值
  */
var friend=
  firstArg matches{
    case "salt"=>"pepper"
    case "chips"=>"salsa"
    case _=>"huh?"
  }

/**
  * 变量范围
  *  scala允许在嵌套范围内定义同名变量
  *  先打印2 ，再打印1
  *  内部变量 被认为遮蔽了同名的外部变量，因为在内部范围中外部变量变得不可见
  */
val a=1;
{
  val a=2;
  println(a)
}
println(a)

// 以序列形式返回一行乘法表
def makeRowSeq(row:Int)=
 for (col<- 1 to 10) yield {
   val prod = (row * col).toString
   val padding = " " * (4-prod.length)
   padding+prod
 }