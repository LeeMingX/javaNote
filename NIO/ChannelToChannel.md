#### Java NIO Channel to Channel Transfers

在Java NIO中，如果其中一个channel是 *FileChannel*，可以直接从一个channel中将数据传送到另一个channel中。*FileChannel*类中有transferTo()和transferFrom()方法可以完成这种功能

###### transferFrom()

`FileChannel.transferFrom()`方法可以将数据从源channel传输到另一个FileChannel中。

```java
RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
FileChannel fromChannel = fromFile.getChannel();

RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
FileChannel toChannel = toFile.getChannel();

long position = 0;
long count = fromChannel.size();

toChannel.transferFrom(fromChannel, position, count);
```

position参数和count参数声明在目标文件中写入数据的起始位置和最大的数据大小，如果源channel中的数据少于count，那么少于count的数据被传输

此外，在SocketChannel的实现方法中，可能SocketChannel内部的缓冲区的数据准备好就会被传输，即使它即将获取更多的数据，因此，它可能不会传输所有请求的数据(count)从它自身到FileChannel

###### transferTo

`transferTo`方法从一个FileChannel中将数据传输到另一个中

```java
RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
FileChannel fromChannel = fromFile.getChannel();

RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
FileChannel toChannel = toFile.getChannel();

long position = 0;
long count = fromChannel.size();

toChannel.transferFrom(fromChannel, position, count);
```

除了调用方法的FileChannel对象不同，其它基本一样

对于SocketChannel的问题依然存在，FileChannel中的数据向SocketChannel中传输时，只有当发送缓冲区满的时候才会停止