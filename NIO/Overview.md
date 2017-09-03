#### NIO包括以下三个核心组建
1. Channels
2. Buffers
3. Selectors

###### Channels and Buffers
Channel类似于流，数据可以从Channel读入到Buffer中，数据也可以从Buffer中写入到Channel中

NIO中Channel的主要实现形式
* FileChannel
* DatagramChannel
* SocketChannel
* ServerSocketChannel
NIO中Buffer的主要实现形式
* ByteBuffer
* CharBuffer
* DoubleBuffer
* FloatBuffer
* IntBuffer
* LongBuffer
* ShortBuffer

###### Selcectors
Selector允许单个线程处理多个Channel，如果程序有许多打开的连接，但是每个连接的交叉很少，使用selector很方便
