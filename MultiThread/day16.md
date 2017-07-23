### 多线程
线程：程序的一条执行路径      
进程和线程的本质区别：每个进程拥有自己的一整套变量，而线程则共享数据

线程可以有如下6种
1. New(新创建)：用new操作符创建了一个新线程时，该线程还没有开始运行，此时该线程的状态为new
2. Runnable(可运行)：一旦调用start方法，线程处于runnable状态，一个可运行的线程可能正在运行也可能没有运行，取决于操作系统给线程提供运行的时间。线程调度的细节依赖于操作系统提供的服务，在任何给定时刻，一个可运行的线程可能正在运行也可能没有在运行
3. Blocked(被阻塞)：当线程处于被阻塞或等待状态时，它暂时不活动，它不运行任何代码且消耗最少的资源，知道线程调度器重新激活它。当一个线程试图获取一个内部的对象锁(不是java.util.concurrent库中的锁)，而该锁被其它线程持有，则该线程进入阻塞状态，当所有其它线程释放该锁，并且线程调度器允许本线程持有它的时候，该线程将变成非阻塞状态
4. Waiting(等待)：当线程等待另一个线程通知器一个条件时，它自己进入等待状态。在调用Object.wait()方法或Thread.join()方法，或者是等待java.util.concurrent库中的Lock或Condition时
5. Timed waiting(计时等待)：有几个方法有一个超时参数，调用它们导致线程计入计时等待状态，该状态一直保持到超时期满或者接收到适当的通知。带有超时参数的方法有Thread.sleep()和Object.wait()、Thread.join()、Lock.tryLock以及Condition.await的计时板
6. Dead(死亡)
   1. run方法正常退出而自然死亡
   2. 因为一个没有捕获的异常终止了run方法而意外死亡

![线程状态转换](photo/ThreadStateTransfer.png)

调用getState()方法可以确定当前线程的状态

具有多个处理器的机器上每个处理器运行一个线程，可以有多个线程并行运行，如果线程的数目多于处理器的数目，调度器采用时间片机制

##### 线程优先级
默认情况下，一个线程继承它的父线程的优先级，可以用setPriority()方法来提高或者降低一个线程的优先级。

优先级范围在MIN_PRIORITY(1)与MAX_PRIORITY(10)之间的任意值，NORM_PRIORITY(5)

当线程调度器有机会选择新线程时，它首先选择具有较高优先级的线程，线程的优先级高度依赖于系统。

##### 守护线程
t.setDaemon(true) 设置某个线程为守护进程，为其它线程提供服务，当只剩下守护线程的时候，程序结束。

守护线程永远不去访问固有资源，如文件、数据库、因为它会在任何时候甚至在一个操作的中间发生中断

##### 未捕获异常处理器
在线程死亡之前，异常被传递到一个用于未捕获异常的处理器

该处理器必须属于实现Thread.UncaughtExceptionHandler接口的类。这个接口只有一个方法
void uncaughtException(Thread t, Throwable e)

可以用setUncaughtExceptionHandler方法为任何线程安装一个处理器，也可以用Thread类的静态方法setDefaultUncaughtExceptionHandler为任何线程安装一个默认的处理器。替换处理器可以使用日志API发送未捕获异常的报告到日志文件

如果两个线程存取相同的对象，并且每一个线程都调用了一个修改该对象状态的方法，根据各线程访问数据的次序，可能会产生讹误的对象，这样的情况通常称为竞争条件

创建多线程的方式
1. 继承java.lang.Thread
   1. 创建一个继承于Thread的子类
   2. 重写Thread类的run()方法，方法内实现此子线程要完成的功能
   3， 创建一个子类的对象
   4. 调用线程的start()方法
      * 启动此线程
      * 调用run()方法
2. 通过实现Runnable接口的方式 
   1. 创建一个实现了Runnable接口的类
   2. 实现接口的抽象方法
   3. 创建一个Runnable接口实现类的对象
   4. 将此对象作为形参传递给Thread类的构造器中，创建Thread类对象，此对象即为一个线程
   5. 调用start()方法，启动线程并执行run()

**Note：** 一个线程只能执行一次start()方法，不能通过Thread的子类对象调用run()方法来启动线程

Thread的常用方法
1. start()：启动线程并执行相应的run()方法
2. run()：子线程要执行的代码放入run()方法
3. currentThread()：静态的调取当前的线程
4. getName()：获取此线程的名字
5. setName()：设置此线程的名字
6. yield()：调用此方法的线程强制释放当前CPU的执行权
7. join()：在A线程中调用B线程的join()方法，表示当执行到此方法，A线程停止执行，直至B线程执行完毕，A线程再接着join()之后的代码
8. isAlive()：判断当前线程是否存活
9. sleep(long millSecond)：显式地让当前线程睡眠 - 毫秒
10. wait() notify() notifyAll() 有关线程通信

设置线程的优先级
1. getPriority()：返回线程优先级
2. setPriority(int newPriority)：改变线程的优先级

继承方式与实现方式做比较
1. 联系：public class Thread implements Runnable
2. 对比：实现过程避免了java中单继承的局限性，如果多个线程操作一个资源，实现方式不需要声明静态变量

线程安全问题存在的原因：由于一个线程在操作共享数据中，未执行完毕的情况下，另外的线程参与进来，导致共享数据存在了安全问题

如何解决线程的安全问题：必须让一个线程操作共享数据完毕之后，其他线程才有机会参与共享数据的操作

##### 线程的同步机制
方式一：同步代码块
```
synchronized(对象／同步监视器) {
	//需要被同步的代码（操作共享数据的代码）
}
```
1. 共享数据：多个线程共同操作的同一个数据，即变量
2. 同步监视器(锁／this)，由一个类的对象来充当，获取此监视器的线程执行代码块中的代码，this表示当前对象。继承的方式中要慎用this

方式二：同步方法      
将操作共享数据的方法声明为synchronized，即此方法为同步方法，能够保证当其中一个线程执行此方法时，其它线程等待至此线程执行完此方 法。同步方法的锁：this

线程同步的弊端：由于同一时期内只能有一个线程访问共享数据，效率变低

##### 死锁问题
不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源，就形成了线程的死锁

设计阶段应该避免死锁问题

##### 线程通信
1. wait()：挂起线程，一个线程执行到wait()，释放当前锁
2. notify()：唤醒队列中优先级最高的线程
3. notifyAll()：唤醒所有线程

**Note：** 只能在synchronized代码块和synchronized方法中使用

### 锁对象
两种机制防止代码块受并发访问的干扰      
1. ReentrantLock保护代码块的基本结构如下
```
Lock myLock = new ReentrantLock();

myLock.lock();
try{
   critical section
}
finally
{
   myLock.unlock();
}
```
这一结构确保任何时刻只有一个线程进入临界区，一旦一个线程封锁了锁对象，其他任何线程都无法通过lock语句。当其他线程调用lock时，它们被阻塞，直到第一个线程释放锁对象

锁是**可重入** 的，线程可以重复地获得已经持有的锁。锁保持一个持有计数来跟踪对lock()方法的嵌套调用

##### 条件对象
通常，线程进入临界区，发现在某一条件满足之后才能执行，要使用一个条件对象来管理那些已经获得了一个锁但是却不能做有用工作的线程。条件对象通常被称为条件变量
```
Condition sufficientFunds(变量名为要判断的条件)

Constructor {
   sufficientFunds = bankLock.new Condition();
}

//对await的调用应该在如下形式的循环体中
while(!(ok to proceed))
   condition.await();

//将该线程放到条件的等待集中
void await()
//解除该条件的等待集中的所有线程的阻塞状态
void signalAll()
//从该条件的等待集中随机选择一个线程，解除其阻塞状态
void signal()
```

锁和条件的关键之处：
1. 锁用来保护代码片段，任何时刻只能有一个线程执行被保护的代码
2. 锁可以管理试图进入被保护代码段的线程
3. 锁可以拥有一个或多个相关的条件对象
4. 每个条件对象管理已经进入被保护的代码块但是还不能执行的代码

##### synchronized关键字
从1.0版本开始，Java中的每一个对象都有一个内部锁，如果一个方法用synchronized关键字声明，那么对象的锁会保护整个方法。要调用该方法，线程必须获得内部的对象锁。内部锁只有一个相关条件。wait()方法添加一个线程到等待集中，notifyAll(/notify()方法解除等待线程的阻塞状态
```
public synchronized void method() {
   while(condition) 
      wait();

   identical statement;

   notifyAll();
}
```
理解的关键点：每一个对象有一个内部锁，并且该锁有一个内部条件。由锁来管理试图进入synchronized方法的线程，由条件来管理那些调用wait的线程

**Note：** 将静态方法声明为synchronized也是合法的，调用这种方法时，该方法获得相关的类对象的内部锁。没有其他线程可以调用同一个类的这个或任何其他的同步

##### 同步阻塞
```
synchronized (lock) {
   statements...
}
```

##### Volatile域
volatile关键字为实例域的同步访问提供了一种免锁机制。如果声明一个域为volatile，那么编译器和虚拟机就知道该域是可能被另一个线程并发更新的。

##### final变量
当域声明为final时，可以安全地访问这个共享域

##### 读/写锁
```
//构造一个ReentrantReadWriteLock对象
private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock()
//抽取读锁和写锁
private Lock readLock = rwl.readLock();
private Lock writeLock = rwl.writeLock();
//对所有获取方法上读锁
public double getTotal() {
   readLock.lock();
   try {...}
   finally { readLock.unlock() }
}
//对所有修改方法上写锁
public void transfer(,,,) {
   writeLock.lock();
   try {...}
   finally { writeLock.unlock() }
}
```
读锁：可以被多个读操作共用的读锁，会排斥所有写操作    
写锁：排斥所有其他的读操作和写操作