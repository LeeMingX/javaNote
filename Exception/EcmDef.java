/**
 * Created by lxghost on 2017/7/9.
 */
public class EcmDef {
    public static void main(String[] args) {
        try {
            System.out.println(args.length);

            double x = Double.parseDouble(args[0]);
            double y = Double.parseDouble(args[1]);

            if (x < 0 || y < 0)
                throw new EcDef("不能输入负数");
//            if (args.length != 2)
//                throw new ArrayIndexOutOfBoundsException("boom");
            double result = ecm(x, y);
            System.out.println(result);
        } catch (ArithmeticException | NumberFormatException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("before boom");
            e.printStackTrace();
        }
    }

    static double ecm(double x1, double x2){
        return x1 / x2;
    }
}

class EcDef extends RuntimeException {

    static final long serialVersionUID = -7034897190745766939L;

    public EcDef() {
        super();
    }

    public EcDef(String message) {
        super(message);
    }
}
