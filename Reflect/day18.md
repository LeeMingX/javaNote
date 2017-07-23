### Java的反射机制
反射机制允许程序在执行期借助于ReflectionAPI取得任何类的内部信息，并能直接操作任意对象的内部属性及方法
```java
// 创建clazz对应的运行时类Person类的对象
Class clazz = new Person.class;
Person p = (Person) clazz.newInstance();

// 通过反射调用运行时类的指定的属性
// 1.public权限属性
Field f1 = p.getField("name");
f1.set(p, "pig");

// 2.private权限属性
Field f2 = p.getDeclaredField("age");
f2.setAccessible(true);
f2.set(p, 20);

// 通过反射调用运行时类的指定的方法
Method m1 = clazz.getMethod("show");
m1.invoke(p);

// getMethod方法在方法名参数后的参数是方法的形参列表
Method m2 = clazz.getMethod("display", String.class);
m2.invoke(p, "china");
```

##### Class类
java.lang.class -> 反射的源头       
当一个类被编译之后，生成对应的.class文件，JVM的类加载器将此.class文件加载进内存，称为一个运行时类，存在在缓存区，这个运行时类对应着一个Class的实例
1. 每个运行时类只加载一次
2. 可以对Class的实例进行如下操作
   * 创建对应的运行时类的对象
   * 可以获取对应的运行时类的完整结构(属性、方法、构造器、内部类、父类、包、异常、注解等)
   * 调用对应的运行时类指定的结构(属性、方法、构造器)
   * 动态代理

获取Class实例的方法
1. 调用运行时类本身的.class属性
2. 通过运行时类的对象获取
3. 通过Class的静态方法获取
4. 通过类加载器

##### 类加载器ClassLoader
启动类加载器(bootstrap)
1. 引导类加载器
2. 扩展类加载器
3. 系统类加载器

从指定包下获取一个文件
```java
ClassLoader cl = this.getClass().getClassLoader();
InputStream is = cl.getResourceAsStream("com/atguigu/java/jdbc.properties");
```

创建对应的运行时类的对象，使用newInstance()方法，实际上是调用了运行时类的空参构造器
1. 要求对应的运行类有空参构造器
2. 构造器的权限要足够大

##### 通过反射获取类的完整结构
1. 获取对应的运行时类的属性
   1. getFields()：只能获取到运行时类中声明为public的属性
   2. getDeclaredFields()：获取运行时类本身声明的所有属性
   3. 获取属性的各个部分的内容
      * 获取每个属性的权限修饰符：field.getModifiers()返回一个int值，Modifier.toString(int)返回修饰符的内容
      * 获取属性的变量类型：field.getType()返回Class的类型，getName()方法获取变量类型
      * 获取属性名
2. 获取运行时类的方法
   1. getMethods()：获取到运行时类及其父类所有声明为public的方法
   2. getDeclaredMethods()：获取运行时类本身声明的所有的方法
   3. 获取方法的各个部分的内容
      * 获取方法的注解：getAnnotations()
      * 获取方法的权限修饰符：同属性
      * 获取方法的返回值类型：getReturnType()，返回值为Class类型，通过getName()方法获得
      * 获取方法的形参列表：getParameterTypes()，返回一个Class数组对象，使用getName()方法遍历数组获得
      * 获取异常类型：getExceptionTypes()方法获得异常类型，返回值类型为Class数组对象，通过getName()方法获得异常类型
3. 获取运行时类的构造器
   1. getConstructors()：返回Constructor数组对象类型，得到运行时类及其父类的声明为public的构造器
   2. getDeclaredConstructors()：得到本类所有声明的构造器
4. 获取运行时类的父类：getSuperclass()，返回类型为Class
5. 获取带有泛型的父类：getGenericSuperclass()，返回类型为Type对象
6. 获取父类的泛型：`ParameterizedType param = (ParameterizedType) Type` ->带有泛型的父类对象，使用getActualTypeArguments()方法，返回一个Type数组对象，使用getName()方法遍历数组获得父类的泛型类型
7. 获取实现的接口：getInterfaces()方法，返回一个Class数组对象，使用getName()遍历数组获得接口，获取不到接口继承的父类接口
8. 获取所在的包：getPackage()返回一个Package类型的对象
9. 获取关于类的注解：class.getAnnotations()，返回一个Annotation数组对象，通过遍历数组得到注解

##### 调用指定的属性、方法以及构造器
1. 调用运行时类当中指定的属性
   1. 获取指定的属性：`Field name = Class.getField(String)`
   2. 创建运行时类的对象：`Person p = Class.newInstance()`
   3. 将运行时类的指定的属性赋值：`name.set(p, String)`
   4. `Class.getDeclaredField(ing)`和`age.setAccessible(true)`获取指定的声明为private的属性
2. 调用运行时类当中指定的方法
   1. getMethod(String, Class ... params)：获取运行时类中国年声明为public的方法，返回Method对象
   2. 调用指定的方法：`method.invoke(Object, Object ... obj)`，其返回值是方法的返回值
   3. 对于静态方法的调用同上
   4. 对于非public的方法的调用：`getDeclaredMethod(String, Class ... params)`,需要`method.setAccessible(true)`设置允许访问，调用同上。
3. 调用运行时类的指定的构造器
   1. `Constructor cons = Class.getDeclaredConstructor(Class ... params)`和`cons.setAccessible(true)`，使用Constructor对象的newInstance()方法来创建对象实例

##### 动态代理
动态代理的使用
```java
interface Subject {
	void action();
}

//被代理类
class RealSubject implements Subject {
	public void action() {
		System.out.println("我是被代理类！！");
	}
}

//代理类
class MyInvocationHandler implements InvocationHandler {
	Object obj;//实现了接口的被代理类的对象的声明

    //1.给被代理类的对象实例化 2.返回一个代理类的对象
	public Object blind(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader), obj.getClass().getInterfaces(),this);
	}

	//当通过代理类的对象发起对被重写的方法的调用时，都会转变为对invoke()方法的调用
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object returnVal = method.invoke(obj, args);
		return returnVal;
	}
}
```
