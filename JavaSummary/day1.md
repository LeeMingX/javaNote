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
##### 2.安装JDK并配置环境变量
系统环境变量中的path，追加`%JAVA_HOME_PATH%\bin;%JAVA_HOME_PATH%\jre\bin`
##### 3.HelloWorld程序以及常见问题解答
* 源文件以.java结尾
* 源文件中可以有多个class声明的类
* 类中可以有主方法（main方法），格式固定public static void main(String[] args)
* main()方法是程序的入口，方法内是程序的执行部分
* 一个源文件中只能有一个public的类，同时要求此类的类名与源文件名相同
* 每条语句以";"结尾
* 执行程序： 编译 -> javac filename.java；运行 -> java classname
##### 4.文档注释
```
/**
@author author-name
@version version-number
*/
```
