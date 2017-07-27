### 枚举类
枚举类：类的对象是有限个，确定的      
自定义一个枚举类
```
class Season {
	//提供类的属性，声明为private final
	private final String seasonName;
	private final String seasonDesc;

	//声明为final的属性，在构造器中初始化
	private Season(String name, String desc) {
		this.seasonName = name;
		this.seasonDesc = desc;
	
	//创建枚举类的对象
	public static final SPRING = new Season("spring", "this is spring");

	public static final SPRING = new Season("summer", "this is summer");

	public static final SPRING = new Season("fall", "this is fall");

	public static final SPRING = new Season("winter", "this is winter");

	//通过公共方法来调用属性
	public String getSeasonName() {
		return this.seasonName;
	}

	public String getSeasonDesc() {
		return this.seasonDesc
	}
}
```

##### 使用enum关键字定义枚举类
使用enum关键字定义枚举类和自定义枚举类的区别：
* 省略声明的对象的修饰符和new关键字     
* 不同的对象用逗号隔开，最后一个对象后加分号     
* 其余属性和和方法声明放在对象后面

1. 常用的方法
   * EnumObject.values()：以数组形式返回枚举类中声明的对象
   * EnumObject.valueOf(String str)：根据声明的枚举类对象名来返回枚举类中的对象
2. 如何让枚举类实现接口：在声明的枚举类对象后加一个代码块，其中重写实现接口中的方法。可以让不同的枚举类的对象调用被重写的抽象方法，执行的效果不同。

### 注解
1. JDK提供的常用的注解
   * @Override：限定重写父类方法，该注释只能用于方法
   * @Deprecated：用于表示某个程序元素(类、方法等)已过时
   * @SuppressWarnings：抑制编译器警告
2. 如何自定义一个注解
```
public @interface Annotation {
	String value() default "Hello"
}
```
3. 元注解：修饰注解的注解
   * @Retention(RetentionPolicy.CLASS/RUNTIME/SOURCE)：用于指定该注解存在的周期
   * @Target：指定被修饰的Annotation能用于修饰哪些程序元素
   * @Documented：能否被javadoc解析
   * @Inherited：注解是否具有继承性
