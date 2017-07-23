### Java常用类

##### String：代表不可变的字符序列，底层使用char[]存放

String类是final修饰的

常用方法：
1. public int length();返回String对象长度
2. public char charAt(int index);返回在特定位置的字符
3. public boolean equals(Object obj);返回与String对象比较是否相等的结果
4. public int compareTo(String otherStr);返回与另一个String对象比较的结果
5. public int indexOf(String s);返回字符串s在原字符串中首次出现的位置
6. public int indexOf(String s, int startPoint);
返回字符串s在Start位置后的字串中首次出现的位置
7. public int lastIndexOf(String s);
～最后一次
8. public int lastIndexOf(String s, int startPoint);
～最后一次
9. public boolean startsWith(String prefix);
判断是否以prefix开头
10. public boolean startsWith(String suffix);
判断是否以suffix结尾
11. public boolean regionMatches(int firstStart, String other, int otherStart, int length);other字符串在otherstart位置后长度为length的字串与原字符串在firststart位置后的length长度的字串是否相同

##### StringBuffer   
线程安全的可变的字符序列，可以对字符串内容进行增删

常用方法：
* 添加 append()
```
StringBuffer append(String s) 
StringBuffer append(int n) 
StringBuffer append(Object o) 
StringBuffer append(char n) 
StringBuffer append(long n) 
StringBuffer append(boolean n) 
```
* 插入 insert(int index, String str)      
`StringBuffer insert(int index, String str)`

* 反转 reverse() 反转该StringBuffer对象本身     
`public StringBuffer reverse()`

* 删除    
`StringBuffer delete(int startIndex, int endIndex)`

* 查询指定索引位置的字符      
`public char charAt(int n)` 

* 修改单个字符      
`public void setCharAt(int n, char ch)`
* 修改多个字符     
`StringBuffer replace(int startIndex, int endIndex, String str)`

以下方法类似String对象
```
public int indexOf(String str)
public String substring(int start, int end)
public int length() 
```

##### StringBuilder 
可变的字符序列，线程不安全的，方法效率高于StringBuffer

### 日期类
1. java.lang.System类提供的public static long currentTimeMills()，返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
2. java.util.Date类表示特定的瞬间，精准到秒。其子类java.sql.Date的格式为年-月-日，构造器传入一个long型整数
   * Date.getTime()返回一个long型整数
3. SimpleDateFormat类易于国际化
   * 格式化：日期->文本，使用SimpleDateFormat的format()方法
   * 解析：文本->日期，使用
4. Calendar类：抽象基类，使用Calendat.getInstance()方法获得其实例。处理具体日期中的某个部分。

##### BigInteger和BigDecimal
构造器
```java
public BigInteger(String str)

public BigDecimal(double val)
public BigDecimal(String val)
```
常用方法
```java
public BigInteger abs()
public BigInteger add(BigInteger val)
public BigInteger subtract(BigInteger val)
public BigInteger multiply(BigInteger val)
public BigInteger divide(BigInteger val)
public BigInteger remainder(BigInteger val)
public BigInteger pow(int exponent)
public BigInteger[] divideAndRemainder(BigInteger val)

public BigDecimal add(BigDecimal augend)
public BigDecimal subtract(BigDecimal subtrahend)
public BigDecimal multiply(BigDecimal multiolicend)
public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)
```