# JavaStudy
Java详细学习
## 日期和时间
```
创建：
Date()
Date(long millisec)

比较：
boolean after(Date date) //指定日期之后返回true
boolean before(Date date) //指定日期之前返回true
int compareTo(Date date) //相等返回0，之前返回负数，之后返回正数

格式化：
SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");

//Calendar类
Calendar c = Calendar.getInstance();//默认是当前日期

```
## 正则表达式
```
^ 匹配开始位
$ 匹配结束位
* 0次或多次 eg:zo* 与 z zoo 匹配  <=> {0,}
+ 1次或多次 eg: zo+ 与 zo zoo 匹配 <=> {1,}
? 0次或1次  eg:do(es)? 与 do does 匹配
{n} 匹配n次
{n,} 至少匹配n次
{n,m} 至少匹配n次，至多匹配m次

? 当此字符紧随任何其他限定符（*、+、?、{n}、{n,}、{n,m}）之后时，匹配模式是"非贪心的"。"非贪心的"模式匹配搜索到的、尽可能短的字符串，而默认的"贪心的"模式匹配搜索到的、尽可能长的字符串。例如，在字符串"oooo"中，"o+?"只匹配单个"o"，而"o+"匹配所有"o"。

x|y 匹配x或y
[xyz] 匹配包含任一字符
[^xyz] 匹配未包含的任何字符
[a-z]
\d <=> [0-9]
\D <=> [^0-9]
\w <=> [A-Za-z0-9_]
\W <=> [^A-Za-z0-9_]
\b 匹配一个字边界
\B 非字边界匹配
\s 匹配任何空白字符 包括空格、制表符、换页符等。与 [ \f\n\r\t\v] 等效。
\S 匹配任何非空白字符。与 [^ \f\n\r\t\v] 等效。
```
## Java 流(Stream)、文件(File)和IO
## 异常处理
* 检查性异常
  * IOException
* 运行时异常
  * RuntimeException
* 错误
  * Error
###内置常用的运行时异常类
```
ArithmeticException  //算术异常类
ArrayIndexOutOfBoundsException //下标越界
ClassCastException //类转换异常
IllegalArgumentException //参数不合法
NullPointerException //空指针异常
NumberFormatException //数字格式化异常
SecurityException //由安全管理抛出的异常
```
###内置常用的检查性异常类
```
ClassNotFoundException //未找到类
NoSuchMethodException
NoSuchFieldException
CloneNotSupportedException
```
### 处理方式
* 捕获
```
try{
  // 程序代码
}catch(异常类型1 异常的变量名1){
  // 程序代码
}catch(异常类型2 异常的变量名2){
  // 程序代码
}finally{
  // 程序代码
}
```
* throws/throw 抛出异常

## 面向对象
* 继承  
关键字  
extends 类继承类  
implements 类继承接口  
super 通过super关键字实现父类成员的访问
this 指向自己的引用  
final 最终类，不能被继承；最终方法，不能被重写  
* Override /Overload  
Override 重写 使用在继承--子类方法  
Overload 重载 同方法名，不同参数
* 多态  
多态就是同一个接口，使用不同的实例而执行不同操作  
实现方式  
  * 重写
  * 接口
  * 抽象类和抽象方法  
* 抽象类
  * 抽象类不能被实例化
  * 抽象类不一定包含抽象方法，包含抽象方法的类必定是抽象类
  * 构造方法，类方法不能声明为抽象方法
  * 抽象类的子类必须实现抽象方法
* 封装
* 接口
  * 接口不能用于实例化对象
  * 没有构造方法
  * 方法必须是抽象方法
  * 不能包含成员变量（除了static 和final变量）
  * 接口支持多继承
## 高级教程
### 数据结构
 * Vector 动态数组
 * Hashtable 存放键值,类似map
 * Stack 后进先出
 * Properties 键值均为字符串  
### 泛型
 * 泛型方法
 * 泛型类
 * 泛型约束
 * 类型通配符 ?
### 序列化
### 网络编程
### URL处理
```
protocol://host:port/path?query#fragment

eg:http://www.runoob.com/index.html?language=cn#j2se
```
 * 协议为(protocol)：http
 * 主机为(host:port)：www.runoob.com
 * 端口号为(port): 80 ，以上URL实例并未指定端口，因为 HTTP 协议默认的端口号为 80。
 * 文件路径为(path)：/index.html
 * 请求参数(query)：language=cn
 * 定位位置(fragment)：j2se，定位到网页中 id 属性为 j2se 的 HTML 元素位置 。

### 多线程编程
 * 通过实现 Runnable 接口
 * 通过继承 Thread 类本身
 * 通过 Callable 和 Future 创建线程
 
## Java 8 新特性
* Lambda表达式
* 方法引用  ::
* 函数式接口
* 接口的默认方法
* Stream 数据处理
* Optional 类 一个可以为null的容器对象
* 新的日期类
* Base64
## Java连接MySQL数据库

## 注解
* java注解是附加在代码中的一些元信息，用于一些工具在编译、运行时进行解析和使用，起到说明、配置的功能。
* 注解不会也不能影响代码的实际逻辑，仅仅起到辅助性的作用。包含在 java.lang.annotation 包中。
* java自定义注解和运行时靠反射获取注解。

## 工具类
* AES 加解密
* Base64工具



