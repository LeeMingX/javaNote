##### 接口的多态性
```
public class DuckTest {
	public static void main(String[] args) {
		Duck d = new Duck();
		this.Test1(d);
	}
	
	public static void Test1(Runner r) {
		r.run();
	}
}

public interface Runner {
	void run();//虚拟方法调用
}

class Duck implements Runner {
	@Override
	public void run() {
		System.out.println("Duck will run...");
	}
}
```

##### 接口用法总结
1. 实现不相关类的相同行为，不需要考虑这些类之间的层次关系
2. 指明多个类需要实现的方法，定义对象的扩张功能
3. 定义规范，接触耦合关系

##### 工厂方法
```
public class FactoryTest {
	public static void main(String[] args) {
		IWorkFactory iwf = new StudentWorkFactory();
		iwf.getWork().doWork;
	}
}

public interface IWorkFactory {
	Work getWork();
}

class StudentWorkFactory implements IWorkFactory {
	@Override
	public Work getWork() {
		return new StudentWork();
	}
}

class TeacherWorkFactory implements IWorkFactory {
	@Override
	public Work getWork() {
		return new TeacherWork();
	}
}

public interface Work {
	void doWork();
}

class StudentWork implements Work {
	@Override
	public void doWork {
		System.out.println("student will work..");
	}
}

class TeacherWork implements Work {
	@Override
	public void doWork {
		System.out.println("teacher will work..");
	}
}
```

##### 代理模式
```
//静态代理模式
public Class ProxyTest {
	public static void main(String[] args) {
		Object o = new ProxyObject();
		o.action();
	}
}

public interface Object {
	void action();
}

class ObjectImpl implements Object {
	@Override
	public void action() {
		System.out.println("this is a true action");
	}
}

class ProxyObject implements Object {
	Object obj;

	public ProxyObject() {
		obj = new ObjectImpl();
	}

	@Override
	public void action() {
		obj.action();
	}
}
```

### 内部类
类的内部定义类，定义在外面的类称为外部类     
内部类的分类：
1. 成员内部类：类内部、方法外
   * 外部类的一个成员：
      * 可以有修饰符(public default private protected)
      * 可以用static final修饰
      * 可以调用外部类的属性、方法
   * 具有类的特点
      * abstract修饰
      * 在内部定义属性、方法、构造器
2. 局部内部类：类的方法里

掌握部分：
1. 如何创建内部类对象
2. 如何区分调用外部类、内部类的对象(尤其是变量重名的时候)
3. 局部内部类的使用

创建静态内部类的对象，通过外部类的对象调用内部类的构造器
```
public class TestInnerClass() {
	public static void main(String[] args) {
		//创建静态内部类对象
		Person.Dog = new Person.Dog();
		//创建非静态内部类对象
		Person p = new Person();
		Person.Bird.b = p.new.Bird();

		b.setName("small small boom");
	}
}

class Person{
	String name = "boom";
	int id;

	Public Person(){

	}
	
	class Bird {
		String name = "small boom";
		int id;

		public Bird() {

		}

		public void setName(String name) {
			System.out.println(name);//small small boom
			System.out.println(this.name);//small boom
			System.out.println(Person.this.name);//boom
		}
	}

	static class Dog {
		public Dog() {

		}
	}
	
}
```

##### 局部内部类的通常使用方法
```
public Comparable getComparable() {
	class MyComparable implements Comparable {
		@Override
		public int compareTo(java.lang.Object o) {
			return 0;
		}
	}

	return new MyComparable();
}
//可以直接返回一个匿名内部类
public Comparable getComparable() {
	
	return new MyComparable() {
		@Override
		public int compareTo(java.lang.Object o) {
			return 0;
		}
	};
}

```

### 异常处理
java.lang.Throwable
* Error：错误，程序不进行处理
* Exception：异常，在编程过程中需要考虑并进行处理

Exception分为编译时异常和运行时异常
1. 编译期间出现的异常：运行javac.exe命令时出现异常
2. 运行期间出现的异常：运行java.exe命令时出现异常
   * 数组下标越界异常 ArrayIndexOutOfBoundsException
   * 算术异常 ArithmeticException 
   * 类型转换异常 ClassCastException
   * 空指针异常 NullPointerException

**Note:** 当执行一个程序时，一旦出现异常，异常之后的代码不再执行

##### 如何处理异常
java提供的是异常处理的抓抛模型
1. “抛”：执行代码时，一旦出现异常，就会在异常的代码处生成一个对应的异常类型对象，并将此对象抛出(自动抛出／手动抛出)
   * 一旦抛出异常类型对象，那么程序终止运行
   * 此异常类的对象抛给调用者
2. “抓”：抓住跑出来的异常类的对象，java提供了两种方式来处理一个异常类的对象
   * try-catch-finally：
      * try语句块中声明的变量类似于局部变量
      * finally语句块是可选的 
      * catch语句是对异常对象的处理，可以有多个catch语句
      * 在try语句中抛出的异常类对象按顺序匹配catch中异常类的类型，一旦满足就执行catch字句，执行完就退出之后的catch语句
      * 如果异常被处理了，那么之后的代码继续执行。
      * getMessage(),printStackTrace()
      * 运行时异常可以不处理
      * 编译时异常必须处理
      * catch字句中，若多个异常类型是并列关系，则编写顺序任意，若异常类型是包含关系，则先处理子类异常对象
      * finally中是一定会被执行的代码，不管try、catch中仍有异常未被处理以及是否有return语句
      * try-catch是可以相互嵌套

```
//try-catch结构
try {
	//可能出现异常的代码
	...
} catch(Exception e) {
	//处理的方式1
} catch(Exception e) {
	//处理的方式2
} finally {
	//一定要执行的代码
	//可选的结构 
}
```
