/**
 * Created by lxghost on 2017/7/1.
 */
public class ObjectTest {
    public static void main(String[] args) {
        Circle c = new Circle();
        PassObject po = new PassObject();
        po.printAreas(c, 5);
    }
}

class Circle {
    double radius;

    public double calCircleArea() {
        double result = Math.PI * Math.pow(radius,2);
        return result;
    }

    public void setRadius(double r) {
        radius = r;
    }

    public double getRadius() {
        return radius;
    }
}

class PassObject {
    public void printAreas(Circle c, int times) {
        System.out.println("Radius\t\tAreas");
        for (int i = 1; i <= times; i++) {
            c.setRadius(i);
            System.out.print(i + "\t\t" + c.calCircleArea() + "\n");
            if (i == times)
                c.setRadius(i + 1);
        }
        System.out.println("now the radius is " + c.getRadius());
    }
}