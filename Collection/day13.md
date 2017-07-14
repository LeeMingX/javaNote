### 集合概述及特点
存储对象可以考虑：数组、集合

数组存储对象的特点：
1. 一旦创建，其长度不可变
2. 数组真实存放的对象个数是不可知的

java集合包括Collection和Map两种体系：
1. Collection接口
   * Set 元素无序，不可重复的集合 类似“集合”
      1. HashSet、LinkedSet、TreeSet
   * List 元素有序，可重复的集合 “动态”数组
      1. ArrayList(主要的实现类)、LinkedList、Vector
2. Map接口：具有映射关系的“key-value”的集合 类似于“函数”
   * HashMap、LinkedHashMap、TreeMap、HashTable(子类-Properties)

##### Collection的常用方法
```
Collection coll = new ArrayList();

//size()：返回集合中元素的个数
coll.size();
//add(Object obj)：向集合中添加一个元素
coll.add();
//addAll(Collection coll)：将形参coll中包含的所有元素添加到当前集合中
Collectoin coll2 = Arrays.asList(1,2,3);
coll.addAll(coll2);
//isEmpty()：判断集合是否为空
coll.isEmpty();
//clear()：清空集合元素
coll.clear();

//contains(Object obj)：判断集合中是否包含指定的obj元素
//判断的依据是元素所在类的equals()方法，如果equals()方法没有重写，那么会比较两个元素的地址值
//如何存入集合中的元素是自定义类的对象，要求自定义类要重写equals()方法
boolean b1 = coll.contains(b1);
//containsAll(Collection coll)：判断当前集合是否包含指定集合的所有元素
Collection coll1 = new ArrayList();
boolean b2 = coll.containsAll(coll1);
//retainAll(Collection coll)：求当前集合与coll的共有元素，返回给当前集合
boolean b3 = coll.retainAll(coll1)
//remove(Object obj)：删除集合中的obj元素
coll.remove(1);
//removeAll(Collection coll)：从当前集合中删除包含在coll中的元素
coll.removeAll(coll1);
//equals(Object obj)：判断两个集合中的所有元素是否完全相同
coll.equals(coll1);
//hashCode()：得到coll的哈希值
coll.hashCode();
//toArray()：将集合转化成数组
Object[] obj = coll.toArray();
for (int i = 0; i < obj.length; i++) {
	System.out.println(obj[i]);
}
//iterator()：返回一个Iterator接口实现类的对象,进而实现接口的遍历
//next()方法中Iterator对象的指向对象地址会后移
Iterator iter = coll.iterator();
while (iter.hasNext()) {
	System.out.println(iter.next());
}

//增强for循环中的o作为一个局部变量，不能利用o来修改集合中的值
for (Object o : coll) {
	System.out.println(o);
}
```

##### ArrayList及List的常用方法
ArrayList新增加的方法
* void add(int index, Object ele)
* boolean addAll(int index, Collection eles)
* Object get(int index)
* int indexOf(Object obj)
* int lastIndexOf(Object obj)
* Object remove(int index)
* Object set(int index, Object ele)
* List sublist(int fromIndex, int toIndex)

LinkedList即使用链表实现List接口，便于频繁的插入、删除操作
Vector是线程安全的

**Note:** 添加进list集合中的元素或对象所在的类一定要重写equals()方法

### Set接口及其实现类
Set中常用的方法都是Collection下定义的       
Set中的元素存储方式：哈希算法

> 当向Set中添加对象时，首先调用此对象所在类的hashCode()方法，计算此对象的哈希值，此哈希值决定了该对象在Set中的存储位置，若此位置之前没有对象存储，则这个对象直接存储到此位置，若此位置已有对象存储，再通过equals()方法比较这两个对象是否相同，如果相同，后一个对象就不能再添加进来

不建议这样做：
若hashCode()方法返回值相同，但是equals()方法比较的结果为false，那么Set中该位置可以存储这两个对象

hashCode()对两个相同属性的对象计算出的hashCode值是不一致的，不能应用

IDE自动生成的hashCode()方法保证了健壮性

hashCode()方法要与equals()方法一致

1. HashSet：主要实现类
   1. 无序性：不代表随机性，指的是元素在底层存储的位置是无序的
   2. 不可重复性：当向Set中添加相同的元素的时候，后添加的过程是无效的。**Note:** 要求添加进Set中的元素所在的类，一定要重写equals()和hashCode()方法
2. LinkedHashSet
   1. 使用链表维护了一个添加进集合中的顺序，导致当我们遍历LinkedHashSet集合元素，是按照添加进去的顺序遍历的
   2. 依旧有存储的无序性
   3. LinkedHashSet插入性能略低于HashSet，但在迭代访问Set里的全部元素中有最好的性能
3. TreeSet
   1. 向TreeSet中添加的元素必须是同一个类的
   2. 可以按照添加进集合中的元素的指定的顺序遍历。String、包装类等默认按照从小到大的顺序遍历
   3. 向TreeSet中添加自定义类的对象，有两种排序方法
      * 自然排序：要求自定义类实现java.lang.Comparable接口并重写其compareTo(Object o)方法，此方法中可以自定义类的哪个属性进行排序。向TreeSet中添加元素时，首先按照compareTo()方法进行比较，一旦返回0，虽然仅是两个对象的此属性值相同，但是程序会认为这两个对象相同，进而后一个对象不能添加进去
      ```
	  //当自定义类没有实现Comparable接口时，该类的实例化对象不能添加到TreeSet中
	  //向TreeSet中添加Person类的对象时，依据compareTo()方法，确定根据哪个属性排列
	  class Person {
	  	private String name;
	  	private int age;

	  	@Override
	  	public int compareTo(Object o) {
	  		if (o instanceof Person) {
	  			Person p = (Person) o;
	  			return this.name.compareTo(p.name);
	  		}
	  		return 0;
	  	}
	  }
      ```
      * 定制排序
      ```
      //创建一个实现了Comparator接口的类对象
      Comparator com = new Comparator() {
      	//向TreeSet中添加自定类的对象，在此compare()方法中，指明是按照自定类的哪个属性排序的
      	@Override
      	public int compare(Object o1, Object o2) {
      		if (o1 instanceof Customer && o2 instanceof Customer) {
      			Customer c1 = (Customer) o1;
      			Customer c2 = (Customer) o2;
      			return c1.getId().compareTo(c2.getId());
      		}
      		return 0;
      	}
      }

      //将此对象作为形参传递给TreeSet的构造器中
      TreeSet set = new TreeSet(com);
      //向TreeSet中添加Comparator接口中的compare方法中涉及的类的对象
      ```

**Note:** compareTo()方法与hashCode()方法以及equals()方法三者保持一致

### Map接口
1. HashMap：Map的主要实现类
2. LinkedHashMap：使用链表维护添加进Map的顺序，遍历时按照添加的顺序
3. TreeMap：按照添加进Map中的元素的key的指定属性进行排序
   * 自然排序
   * 订制排序
4. Hashtable：线程安全，不允许key与value存储null值
   * Properties：常用来处理属性文件，键🈴️值都为String类型

Map中的主要方法：
```
//向Map中添加一个元素
Object put(Object key, Object value)
//按照指定的key删除此key-value
Object remove(Object key)
//将一个新的Map中所有值添加进此Map中
void putAll(Map t)
//清空
void clear()
//获取指定key的value值
Object get(Object key)
boolean containsKey(Object key)
boolean containsValue(Object value)
//返回集合的长度
int size()
boolean isEmpty()
boolean equals(Object obj)
```
**Note:** HashMap：key是用Set来存放的，不可重复，value是用Collection来存放的，可重复
一个Key-Value对是一个Entry，所有的Entry是用Set存放的，也是不可重复的
向HashMap中添加元素时，会调用key所在类的equals()方法，判断两个key是否相同，若相同，则只能够添加进后一个元素

##### 如何遍历Map
```
//遍历所有key
Set keySet()
//遍历所有的value
Collection values()
//遍历key-value对
Set entrySet()

Set set = Map.entrySet();
for (Object obj : set) {
	Map.Entry entry = (Map.Entry) obj;
	System.out.println(entry.getKey() + " " + entry.getValue());
}
```

##### 操作集合的工具类：Collections
主要方法：
```
//以下方法均为static的
//反转list集合中元素的顺序
reverse(List) 
//对list集合元素进行随机排序
shuffle(List)
//根据元素的自然顺序对指定list集合元素按升序排列
sort(List)
//根据指定的Comparator产生的顺序对List集合元素进行排序
sort(List, Comparator)
//将指定List集合中i处元素和j处元素进行交换
swap(List, int, int)

//根据元素的自然顺序，返回集合中的最大元素
Object max(Collection)
//根据Comparator指定的顺序，返回集合中的最大元素
Object max(Collection, Comparator)
Object min(Collection)
Object max(Collection, Comparator)
//返回指定集合中指定元素的出现次数
int frequency(Collection object) 
//将src中的内容复制到dest中
void copy(List dest, List src)
//使用新值替换list中对应的旧值
boolean replaceAll(List list, Object oldVal, Object newVal)

//还有一些同步方法使得list转变为线程安全的
```

##### Enumeration接口
Enumeration接口是Iterator接口的“古老版本”

包含两个方法：
hasMoreElements() -> hasNext()     
nextElement -> next()