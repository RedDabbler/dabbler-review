def echo(args:String*)= for (arg<-args) println(arg)

/** scala可以指定函数的最后一个参数是重复的，
  * 从而允许客户向函数传入可变长度参数列表，
  * 想要标注一个重复参数，可在参数的类型之后放一个 星号
  *
  */

echo()
echo("one")
echo("hello","world")
//类比于java的变长参数

val arr =Array("what","is","fuck")
// 在数据参数后添加一个冒号和一个_ ,告诉编译器把arr的每个元素当作参数，而不是当作单一的参数传给echo
echo(arr:_*)