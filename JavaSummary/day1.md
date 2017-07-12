### java语言概述
##### 1.常用的DOS命令
1. dir：列出当前目录下的文件和文件夹
2. md：创建目录
3. echo write_content > filename.filetype：创建文件
4. rd：删除目录
5. cd：进入指定目录
6. cd ..：退回到上级目录
7. cd \：退回到根目录
8. del：删除文件
9. exit：退出dos命令行
10. start：启动别的命令，默认打开新窗口
11. call：类似start

内部命令：os内部直接支持的命令，和path无关     
外部命令：保存在硬盘某目录中的一个可执行文件，必须和path相关

Windows不区分大小写       
Windows中cmd查看命令帮助：commond /?

##### 2.安装JDK并配置环境变量
java语言的特征
1. 简单：相对c、c++
2. 面向对象：关注具有功能的角色
3. 分布式：基于网络的多主机的协同工作
4. 健壮性：强制类型机制、异常处理、垃圾的自动回收(gc)、指针的安全化(隐藏指针的地址值)是保证java程序的健壮性
5. 安全：类加载器的存在
6. 跨平台：JVM跨平台
7. 性能好：编译型语言
8. 多线程：最大化利用CPU资源，同时响应多客户端

系统环境变量中的path，追加`%JAVA_HOME_PATH%\bin;%JAVA_HOME_PATH%\jre\bin`

JRE运行环境 = JVM + 标准类库       
JDK开发环境 = JRE + 开发工具

##### 3.HelloWorld程序以及常见问题解答
* 源文件以.java结尾
* 源文件中可以有多个class声明的类
* 类中可以有主方法（main方法），格式固定public static void main(String[] args)
* main()方法是程序的入口，方法内是程序的执行部分
* 一个源文件中只能有一个public的类，同时要求此类的类名与源文件名相同
* 每条语句以";"结尾
* 执行程序： 编译 -> javac filename.java；运行 -> java classname

快捷键(windows)：       
shift-tab：整体左移      
ctrl-d：复制行       
ctrl-l：删除行       

##### 4.文档注释
```
/**
@author author-name
@version version-number
*/
```
