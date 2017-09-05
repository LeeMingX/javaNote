#### Java NIO Scatter/Gather

Java NIO具有内置的Scatter和Gather支持，这两个对象是用来从Channel中读取和写入数据的

从一个channel中分散读取是一个读取操作，这个操作将channel中的数据读入到多个buffer中，因此，channel中的数据分散到了多个buffer中

向channel中的聚集写入时一个写入操作，即从多个buffer中将数据写入到channel中，因此，这个channel“聚集“了多个buffer的数据

当你需要分别处理不同部分的数据的时候，Scatter/Gather会很有用，例如，一条信息包括头部分和信息体部分，你可能会将head部分的数据和body部分的数据放在两个不同的buffer中，使用这种方式会提高工作效率

###### Scattering Reads
```java
ByteBuffer header = ByteBuffer.allocate(128);
ByteBuffer body = ByteBuffer.allocate(1024);

ByteBuffer[] bufferArray = {header,body};

channel.read(bufferArray);
```
channel的读取顺序和buffer插入数组的顺序相关。read()方法，将channel中的数据按照顺序写入这两个buffer中，当一个buffer被填满之后，继续向另一个buffer中写入数据

这意味着scattering在读取数据的时候不适合动态大小的数据传输，最好只处理固定大小的buffer

###### Gathering Writes
```java
ByteBuffer header = ByteBuffer.allocate(128);
ByteBuffer body = ByteBuffer.allocate(1024);

ByteBuffer[] bufferArray = {header,body};

channel.write(bufferArray);
```

write()方法向channel中传递buffer的顺序和其在数组中出现的顺序相关，write方法写入一个buffer中的数据是在position和limit之间的，所以write方法可以处理动态大小的数据，这和分散读取方式不同