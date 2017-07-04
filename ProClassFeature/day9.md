### String类的内存解析
通过字面值的方式声明的String对象和通过构造器声明的String对象，当两个String对象存储的内容相同时，它们的地址值是不同的，但是它们同时指向存储在方法区的字符串常量池的String对象，通过构造器声明的String类型也会在堆中开辟一块内存空间，String变量存储的是内存空间的首地址值，所以在“==”的判断中会返回false，但是在“equals()”的判断中会返回true

##### toString()方法
java.lang.Object类的toString()方法的定义如下：
```
public String toString() {
	return getClass().getName() + "@" + Integer.toHexString(hashCode());
}
```
1. 打印一个对象的引用时，默认调用的是这个对象的toString()方法
2. 打印的对象所在的类没有重写Object中的toString()方法时，调用的是Object中定义的toString()方法，返回此对象所在类及对应的堆空间对象实体的首地址值
3. 打印的对象所在的类重写了toString()方法时，调用重写过的toString()方法，将对象的属性信息保存

### 包装类(Wrapper)
| 基本数据类型 | 包装类 |
|---|---|
| byte | Byte |
| int | Integer |
| long | Long |
| char | Character |
| float | Float |
| double | Double |
| boolean | Boolean |
| short | Short|

基本数据类型 -- 包装类 -- String之间的转化    
基本数据类型 -> 对应的包装类，调用包装类的构造器     
构造器的参数可以是对应基本类型和String类型    
String类型中的内容需要与包装类相对应，否则会有异常(java.lang.NumberFormatException)     
对于Boolean包装类，参数只有true会打印true，否则为false

valueOf()是静态的重载的方法
String.valueOf(dataType data／Wrapper)会将基本数据类型转换成String对象，toString()也行    
Wrapper.typeValue()会将包装类类型转换为基本数据类型

JDK5.0以后，有自动装箱和拆箱     
可以直接使用基本数据类型赋值给包装类     
可以直接将包装类对象赋值给基本数据类型

String对象转换为基本数据类型      
dataType var = Wrapper.parseType(String)    

### Junit单元测试方法的使用
eclipse方法：
1. 当前工程下，右键build path-add libraries-Junit4
2. 在主类中，创建一个空参的无返回值方法，方法上声明@test
3. 导入import org.junit.Test
4. 在test1()方法中，编写测试代码
5. 测试：双击方法名，右键run as-junit test

##### static关键字修饰属性
可以用来修饰属性、方法、代码块、内部类    
修饰属性：     
实例变量：非static属性，每个实例都有一套副本           
类变量：static修饰的属性，存储在 __静态域__ ，所有实例共用该属性，其中一个实例对该属性进行修改，会导致其他对象对此属性的调用改变

类变量随着类的加载而加载的，且只有一份      
通过类可以直接调用类变量(ClassName.staticVariable)     
类变量的加载早于对象     
static修饰方法
1. 随着类的加载而加载，内存中只有一份
2. 直接通过(ClassName.staticMethod)的方式调用
3. 静态方法中只能调用类中的静态变量和其他静态方法，不能调用非静态属性和非静态方法，反之则可以调用
4. 静态的方法里不能有this或super关键字

**Note：** 静态结构的生命周期要早于非静态结构，被回收的时间也要晚于非静态结构

##### static的应用
1. 记录创建的对象数