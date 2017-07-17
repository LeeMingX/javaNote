### File类
java.io.File
1. 与输入、输出相关的类、接口等都定义在java.io包下
2. File是一个类，可以有构造器创建其对象，此对象对应一个文件或文件目录
3. File类对象与平台无关
4. File中的方法仅涉及到创建、删除、重命名等操作，只要涉及到文件内容的，File不能操作，由IO流来完成
5. File类的对象常作为io流的具体类的构造器的形参，声明操作的文件路径

相对路径：在当前工程目录下判断文件路径

##### File类中的一些方法
1. 访问文件名
   * getName()：获取文件名
   * getPath()：获取文件路径
   * getAbsoluteFile()：带绝对路径的文件名
   * getAbsolutePath()：绝对路径
   * getParent()：获取上一层文件目录
   * renameTo(File newName)：剪切并重命名，file1.renameTo(file2)，要求file1一定存在，file2一定不存在
2. 文件检测
   * exists()：文件是否存在
   * canWrite()：是否可读
   * canRead()：是否可写
   * isFile()：判断路径是文件
   * isDirectory()：判断路径是文件目录
3. 获取常规文件信息
   * lastModified()：获取文件最后一次修改时间
   * length()：获取文件的大小
4. 文件操作相关：
   * createNewFile()：创建文件
   * delete()：删除文件或目录
5. 目录操作相关
   * mkDir()：创建一个文件目录
   * mkDirs()：创建多层目录
   * list()：以字符串数组的形式存储目录下的所有文件信息
   * listFiles()：以File对象数组的形式存储目录下的所有文件信息

### IO流概述
按照数据流向的不同：      
输入流、输出流

按照处理数据的单位的不同：       
字符流：文本文件，16bit     
字节流：视频、音频以及图片文件，8bit

按照角色的不同：       
节点流：直接访问文件
1. FileInputStream(字节）
2. FileOutputStream(字节）
3. FileReader(字符）
4. FileWriter(字符）
处理流：包装节点流，加速处理速度，可以相互嵌套
1. 缓冲流(分别对应节点流的处理对象)
   * BufferedInputStream
   * BufferedOutputStream
   * BufferedReader
   * BufferedWriter
2. 转换流：在字节流和字符流之间进行转换
   * InputStreamReader
   * OutputStreamWriter
3. 标准的输入输出流：返回字节流对象
   * System.out
   * System.in
4. 打印流
   * PrintStream
   * PrintWriter
5. 数据流：处理基本数据类型、String、字节数组的数据
   * DataInputStream
   * DataOutputStream
5. 对象流：存储和读取对象的处理流
   * ObjectInputStream
   * ObjectOutputStream

##### FileInputStream的使用
1. 创建一个File类的对象
2. 创建一个FileInputStream对象
3. 调用FileInputStream的方法，实现file的读取
4. 关闭相应的流

**Note：** 待读取的文件必须存在，否则报FileNotFoundException异常
，应该使用try-catch语句来处理异常，将流关闭的操作放在finally子句中

read()：读取文件的一个**字节** ，当执行到文件结尾时，返回-1
read(byte[] b)：每次读入b.length长度的字节进数组，返回读取字节的长度，如果无字节，返回-1
```
byte[] b = new byte[5];
int length;
//每此循环输入流会继续读取下一个length长度的字节流进字节数组
//直到读到文件结尾
while((length = fin.read(b)) != -1) {
	//如果循环条件是i < b.length，在第2次循环后数组的内容会被部分或全部替代，那么输出结果会出现错误，所以判断条件应该是读入的字节长度
	for (int i = 0; i < length; i++) {
		System.out.println((char)b[i]);
	}
	//第二种遍历方法，将字节数组构造成字符串
	String str = new String(b, 0, length);
	System.out.print(str);
}
```

##### FileOutputStream的使用以及文件的复制
1. 创建一个File对象，表明要写入的文件路径
2. 创建一个FileOutputStream对象，将File对象作为形参传递给它的构造器
3. 写入
4. 关闭输出流

**Note：** 写入的文件路径可以不存在，当该路径不存在时可以自动创建，若存在，会将原有的文件覆盖。

从硬盘读取一个文件，并写入到另一个位置(即文件的复制)    
在关闭流资源的时候，如果之前一个流中catch字句中需要抛出异常，那么第二个流的关闭操作应该放在第一个流的finally子句中

**Note：** 输入流接受的文件对象必须存在，输出流接受的文件对象可以不存在

##### FileReader和FileWriter的使用
原理同处理字节的流对象相同，字节数组改为字符数组即可，根据处理字符的流对象可以进行文本文件的复制

##### 缓冲流的使用
使用处理字节的缓冲流进行文件的复制
1. 提供读入、写入的文件路径
2. 先创建相应的节点流，FileInputStream和FileOutputStream，形参为之前创建的文件路径
3. 创建缓冲流对象，将节点流的对象作为形参传入构造器
4. 读写操作
5. 关闭流对象

使用缓冲流可以加速读写操作的过程     
对于缓冲流的输出对象，在写入之后要调用flush()方法

##### 转换流的使用
解码：字节数组 -> 字符串     
编码：字符串 -> 字节数组

InputStreamReader构造方法：     
public InputStreamReader(InputStream in)      
public InputStreamReader(InputStream in, String charsetName)

OutputStreamWriter的结构与InputStreamReader类似

##### 常见的编码表

| 编码表 | 描述 |
|---|---|
| ASCII | 美国标准信息交换码：用一个字节的7位表示 |
| ISO8859-1 | 拉丁码表，欧洲码表：用一个字节的8位表示 |
| GB2312 | 中国的中文编码表 |
| GBK | 中国的中文编码表升级，融合了更多的中文文字符号 |
| Unicode | 国际标准码，融合了多种文字：所有文字都用两个字节表示，Java语言使用的是Unicode码 |
| UTF-8 | 最多用3个字节来表示一个字符 |

##### 标准输入输出流
System.in：从键盘输入数据
System.out：从显示器输出数据

##### 打印流
PrintStream：字节流
PrintWriter：字符流

##### 数据流
DataInputStream：读取基本数据类型
DataOutputStream：写入基本数据类型

##### 对象流
ObjectInputStream：反序列化
ObjectOutputStream：序列化

### 对象的序列化机制
允许把内存中的java对象转换成平台无关的二进制流，或通过网络将这种二进制流传输到另一个网络节点

对象的序列化过程，将内存中的对象通过ObjectOutputStream转换为二进制流，存储在硬盘文件中

对象的反序列化过程，将硬盘中的文件通过ObjectInputStream转换为相应的对象

要实现序列化的类：
1. 要求此类是可序列化的
2. 要求类的属性同样实现Serializable接口
3. 提供一个版本号，private static final long serialVersionUID
4. 对象流不能序列化static和transient修饰的成员变量

##### RandomAccessFile类
构造器
```
public RandomAccessFile(File file, String mode)
public RandomAccessFile(String name, String mode)
```

mode参数      
> r：以只读方式打开      
  rw：打开以便读取和写入       
  rwd：打开以便读取和写入；同步问价内容的更新       
  rws：打开以便读取和写入；同步文件内容和元数据的更新

1. 既可以充当一个输入流，也可以充当一个输出流
2. 支持从文件的开头读取和写入
3. 支持从任意位置的读取和写入(覆盖的操作)