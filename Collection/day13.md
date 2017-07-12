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

