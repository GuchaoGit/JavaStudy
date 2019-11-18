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
### 正则表达式
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
### Java 流(Stream)、文件(File)和IO
