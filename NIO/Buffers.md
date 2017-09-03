#### Java NIO Buffer
Buffer在与Channel交互中使用，数据从Channel读入到Buffer，从Buffer写回到Channel，*Buffer*是一块可供读写的内存区域，这块内存区域是NIO Buffer对象来管理

###### Buffer的基本使用
使用Buffer读写数据基本上是以下四步
1. 向Buffer中写入数据
2. 调用buffer.flip()
3. 从Buffer中读取数据
4. 调用buffer.clear()或buffer.compact()

在向buffer写入数据的过程中，buffer会追踪已经写入的所有数据，一旦需要读取数据，应该调用flip()方法来将buffer从写入模式转换为读取模式，在读取模式下可以读出所有写入的数据

在读取了所有的数据之后，要让buffer可以重新写入数据，有两种方式：
1. clear()：将buffer的数据全部清空
2. compact()：只清楚读取的数据，将未读取的数据移到buffer的起始位置，新写入的数据会在未读取数据的后面

###### Buffer Capacity, Position and Limit
Buffer有三个重要的属性
* capacity：是一块内存区域，有固定的大小，只能向Buffer中写入这个固定大小的数据，一旦Buffer满了，在向其中写入数据之前需要清空它(读出数据或清除数据)
* position： 
   * 在写数据时，初始值为0，当写入一个任意数据类型的值时，position的值为buffer要插入数据的单元，position的最大值时capacity-1。
   * 在读数据时，在使用flip()方法将Buffer转化为读数据模式时，position会被重置为0，读数据的位置从position开始，position总是要读取的下一个数据单元
* limit：
   * 在写数据时，limit的值代表可以向Buffer中写入数据的限制，其值与capacity相同
   * 在读数据时，使用flip()切换模式时，limit代表可以从buffer中读取数据的限制，因此，limit的值会被设置为写模式下position的数值，换句话说，只能读取写入数据大小的数据

*position*和 *limit*的值取决于Buffer是读模式还是写模式，*position*总是相同的

###### Buffer类型
ByteBuffer/MappedByteBuffer\CharBuffer/DoubleBuffer/FloatBuffer/IntBuffer/LongBuffer/ShortBuffer

###### 创建一个Buffer
要获取一个Buffer对象，首先应该为其分配大小，每个Buffer都有一个allocate()方法，参数值为分配的对应类型的大小
```java
ByteBuffer buf = ByteBuffer.allocate(48);

CharBuffer buf = CharBuffer.allocate(1024);
```

###### 向一个Buffer中写数据
有两种方式可以向Buffer中写数据
1. 从Channel中向Buffer写数据
`int bytesRead = inChannel.read(buf);`
2. 通过put()方法向Buffer中写数据
`buf.put(127);`

###### flip()
将Buffer从写入数据模式转换为读取数据模式，将position设置为0，将limit设置为position之前的位置，即position现在代表读取数据的起始位置，而limit代表已经写入到Buffer中的数据所在的位置

###### 从Buffer中读取数据
有两种方法从Buffer中读取数据
1. 将Buffer中的数据读取到Channel中
`int bytesWritten = inChannel.write(buf);`
2. 使用get()方法从Buffer中读取数据
`byte aByte = buf.get();`

###### rewind()
Buffer.rewind()会将position的值设为0，而limit的值不会改变，即可以重新读取buffer中的数据，limit的值依旧时可供读取的数据大小

###### clear()和compact()
在读取完buffer中的数据之后，需要将buffer从读取模式转换为写入模式，此时应该调用clear()和compact()方法
1. clear()会将position设置为0，limit设置为capacity，即buffer被清空，但是buffer中的数据不会被清空，只有标记位声明应该从哪个位置写入数据，如果在有为读取数据的情况下调用了clear()方法，那么未读取数据将会被遗忘，如果还有未读取的数据，但是此时需要先写入一些数据，那么应该调用compact()方法
2. compact()复制所有的未读取数据到buffer的起始位置，将position设置为未读取数据的下一位，limit的值设置为capacity

###### mark()和reset()
可以通过调用mark()方法来标记一个position，之后可以通过调用reset()方法来设置position为之前的标记值

###### equals()和compareTo()
可以通过equals()和compareTo()方法来比较两个buffer
1. equals()，两个buffer对象相同的条件
   1. 两个buffer是相同的类型
   2. buffer中的数据元素个数相同
   3. 每个数据元素相同
2. conpareTo()，比较两个buffer中的剩余元素，当一个buffer在具备以下条件是被认为是比另外一个buffer小
   1. 首元素小于其它buffer中的对应元素
   2. 所有的元素都相同，但是第一个buffer先于第二个buffer使用完剩余元素时
