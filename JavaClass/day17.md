### Java常用类

1. String：代表不可变的字符序列，底层使用char[]存放

String类是final修饰的

常用方法：
1. public int length();返回String对象长度
2. public char charAt(int index);返回在特定位置的字符
3. public boolean equals(Object obj);返回与String对象比较是否相等的结果
4. public int compareTo(String otherStr);返回与另一个String对象比较的结果
5. public int indexOf(String s);返回字符串s在原字符串中首次出现的位置
6. public int indexOf(String s, int startPoint);
返回字符串s在Start位置后的字串中首次出现的位置
7. public int lastIndexOf(String s);
～最后一次
8. public int lastIndexOf(String s, int startPoint);
～最后一次
9. public boolean startsWith(String prefix);
判断是否以prefix开头
10. public boolean startsWith(String suffix);
判断是否以suffix结尾
11. public boolean regionMatches(int firstStart, String other, int otherStart, int length);other字符串在otherstart位置后长度为length的字串与原字符串在firststart位置后的length长度的字串是否相同

