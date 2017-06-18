### 赋值运算符与比较运算符的使用
##### 1. 赋值运算符
复合赋值运算符： +=、-=、*=、/=、%=    
__注意：i += j;实际上是`i = (type of i) (i + j)__`    
##### 2. 比较运算符    
| 运算符 | 运算 | 范例 | 结果 |
|---|---|---|---|
| == | 等于 | 4==3 | false |
| != | 不等于 | 4!=3 | true |
| < | 小于 | 4<3 | false |
| > | 大于 | 4>3 | true |
| <= | 小于等于 | 4<=3 | false |
| >= | 大于等于 | 4>=3 | true |
| instanceof | 检查是否是类的对象 | "hello" instanceof String | true |

##### 3.逻辑运算符         
&--逻辑与  \|--逻辑或  !--逻辑非  &&--短路与  \|\|--短路或  ^--逻辑异或  

| a | b | a&b | a\|b | !a | a^b | a&&b | a\|\| b |
|---|---|---|---|---|---|---|---|
| true | true | true | true | false | false | true | true |
| true | false | false | true | false | true | false | true |
| false | true | false | true | true | true | false | true |
| false | false | false | false | true | false | false | false |

&与&&的区别：    
&：不管符号左边是true还是false，右端都会进行计算     
&&：当左端为false时，右端不再进行运算        
\|：符号左端为true，符号右端仍要进行计算      
\|\|：符号左端为true，符号右端不需要进行计算     

##### 4.位运算符
|运算符|运算|范例|解释|
|---|---|---|---|
|<<|左移|3<<2=12-->3\*2\*2=12|数字的二进制形式向左移n位，右边补0，有左移位数限制，\*2操作|
|>>|右移|3>>1=1-->3/2=1|有符号右移，数字二进制形式向右移n位，左边补符号位数字，／2操作|
|>>>|无符号右移|3>>>2=1-->3/2=1|左边补0，／2操作|
|&|与运算|6&3=2|各位做与运算|
|\||或运算|6|3=7|各位做或运算|
|^|异或运算|6\^3=5|各位做异或运算|
|~|反码|~6=-7|各位取反|

**有结论：(m\^n)\^n=m**:
* (m\^n)\^n=m