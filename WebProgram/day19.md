### InetAddress类的创建和使用
位于java.net包下
1. InetAddress代表IP地址，一个InetAddress对象就代表着一个IP地址
2. 获取InetAddress对象：`getByName(String host)`
3. 获取InetAddress对象中的信息
   * 获取域名：`getHostName()`
   * 获取IP地址：`getHostAdress()`
4. 访问本机地址：`getLocalHost()`

### TCP/UDP网络通信协议
1. TCP协议
   * 使用前须先建立TCP连接，形成传输数据通道
   * 传输前进行”三次握手“方式，可靠
   * TCP协议进行通信的两个应用进程：客户端、服务端
   * 在连接中可以进行大数据量的传输
   * 传输完毕要释放已建立的连接，速度慢
2. UDP协议
   * 将数据、源、目的封装成数据包，不需要建立连接
   * 每个数据报的大小限制在64k内
   * 不可靠
   * 发送数据结束无须释放资源，速度快

##### 网络编程实例一
客户端给服务端发送信息，服务端输出此信息到控制台上
1. 客户端代码
   1. 创建一个Socket对象，通过构造器指明服务端的IP地址以及接收的端口号
   2. 调用`getOutputStream()`方法，返回一个OutputStream（子类）对象
   3. 具体的输出过程
   4. 关闭相应的流和Socket
2. 服务端代码
   1. 创建一个ServerSocket的对象，通过构造器指明自身端口号
   2. 调用其`accept()`方法，返回一个Socket对象
   3. 调用Socket对象的`getInputStream()`的方法，获取一个从客户端发送过来的输入流
   4. 对获取的流的操作
   5. 关闭相应的流和Socket

##### 网络编程实例二
客户端给服务端发送一个文件，服务端接收文件并存储到本地
1. 客户端代码
   1. 创建Socket对象
   2. 从本地获取一个文件发送给服务器
   3. 获取来自于服务端的信息
   4. 关闭各种资源
2. 服务端代码
   1. 创建一个ServerSocket对象
   2. 调用其`accept()`方法，返回一个Socket对象
   3. 将从客户端发送来的信息保存到本地
   4. 发送接收信息反馈给客户端
   5. 关闭各种资源

##### 基于UDP的网络编程
发送端：      
创建一个数据报，每个数据报不能大于64k，记录着数据信息，发送端的IP、端口号，以及要接收端的IP、端口号
接收端：        
创建一个数据报，使用的构造器中有一个接收数据的字节数组，以及接收数据的起始位置以及数据长度

### URL编程
URL(Uniform Resource Locator)：统一资源定位符。一个URL对象对应着网络中相应的资源，可以通过URL的对象调用其相应的方法，将此资源读取 
基本格式：`<传输协议>://<主机名>:<端口号>/<文件名>`
```java
//创建一个URL对象
URL url = new URL(String url);
/*
   String getProtocol() //获取URL的协议名
   String getHost()     //获取URL的主机名
   String getPort()     //获取URL的端口号
   String getPath()     //获取URL的文件路径
   String getFile()     //获取URL的文件名
   String getRef()      //获取URL在文件中的相对位置
   String getQuery()    //获取URl的查询名(参数)
*/
InputStream is = url.openStream();

byte[] bs = new byte[20];
int len;
while((len = is.read(bs)) != -1) {
   System.out.println(new String(bs, 0, len));
}

is.close();
```
将URL所代表的资源输出：
```java
//URLConnection
URl url = new URL(String url);

URLConnection uc = url.openConnection();
InputStream is = uc.getInputStream();
FileOutputStream fos = new FileOutputStream(String path);

byte[] bs = new byte[20];
int len;
while ((len = is.read(bs)) != -1) {
   fos.write(bs, 0, len);
}

is.close();
fos.close();
```