/**
hello java
@author Monse
@version v0.1
*/
public class HelloWorld {
    public static void main(String[] args) {
        /*
          打印九行爱心
        */
        System.out.print("  *\t\t\t  *\n");
        System.out.print("*   *\t" + "I love python" + "\t*   *\n");
        System.out.print("  *"+ "\t\t\t  *\n");
        System.out.print("    *" + "\t\t\t*\n");
        System.out.print("      *" + "\t\t      *\n");
        System.out.print("\t*" + "\t    *\n");
        System.out.print("\t  *" + "       " + "*\n");
        System.out.print("\t    *" + "   " + "*\n");
        System.out.print("\t      *\n");
    }
}

class Person {
    public void callMe(String name) {
        System.out.print("call me " + name);
    }
}
