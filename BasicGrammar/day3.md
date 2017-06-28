### 循环结构
1. 循环语句功能    
在某些条件满足的情况下，反复执行特定代码的功能
2. 组成部分
	* 初始化部分
	* 循环条件部分
	* 循环体部分
	* 迭代部分
3. 循环语句分类
	* for循环
	* while循环
	* do/while循环     

##### for循环
1. 格式：
```
for(initialize; condition; iteration) {
	statement;
}
```
2. 过程：     
初始化-->判断条件-->执行语句-->迭代条件-->判断条件···     
直到判断条件不满足则跳出循环

##### while循环
1. 格式
```
[初始化语句]
while (boolean) {
	statements;
	[更改语句；]
}
```
**Note:**循环体内要写终止循环的条件

##### do-while循环
1. 格式
```
do {
	statements;
	[更改语句]
} while(boolean);
```
**Note:**至少执行一遍循环体，其他和while基本相同

##### break与continue关键字的使用
break：结束当前循环         
continue：结束当次循环     
带标签的break和continue：可以在循环之前设置一个标签    
`break text;`可以中断标签处的循环    
`continue text;` 可以在标签处的循环进行下一次循环    
__带标签的循环适用于循环层次较深的情况__

### 一维数组
数组是多个相同类型的数据的集合            
数组中的元素可以是任意数据类型，包括基本数据类型和引用数据类型     
数组属于引用类型，数组型数据是对象，数组中的每个元素相当于该对象的成员变量 

语法格式：      
```
String[] names;
int[] scores;
//初始化
//静态初始化：初始化数组与给数组元素赋值同时进行
names = new String[]{"bob", "amy", "john"};

//动态初始化：初始化数组与给数组元素赋值分开进行
scores = new int[4];
//通过数组元素的下角标方式调用
//下角标范围从0-Array.length-1
//数组的长度，通过数组的length属性获得
//遍历数组元素：for循环
for (int i = 0; i < scores.length; i++) {
	System.out.println(scores[i]);
}
```       
