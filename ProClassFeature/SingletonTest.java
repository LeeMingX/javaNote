/**
 * Created by lxghost on 2017/7/5.
 */
public class SingletonTest {
    public static void main(String[] args) {
        SingletonStarve s1 = SingletonStarve.getSingletonStarv();
        SingletonStarve s2 = SingletonStarve.getSingletonStarv();
        System.out.println(s1 == s2);
        SingletonSluggish ss1 = SingletonSluggish.getSingletonSluggish();
        SingletonSluggish ss2 = SingletonSluggish.getSingletonSluggish();
        System.out.println(ss1 == ss2);
    }
}

class SingletonStarve {

    private SingletonStarve() {
    }

    private static SingletonStarve ss = new SingletonStarve();

    public static SingletonStarve getSingletonStarv() {
        return ss;
    }
}

class SingletonSluggish {

    private SingletonSluggish() {
    }

    private static SingletonSluggish ss = null;

    public static SingletonSluggish getSingletonSluggish() {
        if (ss == null) {
            ss = new SingletonSluggish();
        }
        return ss;
    }
}