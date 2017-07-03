/**
 * Created by lxghost on 2017/7/3.
 */
public class InheritTest {
    public static void main(String[] args) {
        Kids someKid = new Kids(15, 3, 43);
        someKid.manOrWoman();
        someKid.employed();
    }
}

class Mankind {
    private int sex;
    private int salary;

    public Mankind() {
    }

    public Mankind(int sex, int salary) {
        this.sex = sex;
        this.salary = salary;
    }

    public void manOrWoman() {
        if (this.sex == 0) {
            System.out.println("Your sex is woman");
            return;
        }

        if (this.sex == 1) {
            System.out.println("Your sex is man");
            return;
        }

        System.out.println("You are a shabi!!");

    }

    public void employed() {
        if (this.salary == 0)
            System.out.println("no job");
        else
            System.out.println("job");
    }
}

class Kids extends Mankind {
    private int yearsOld;

    public Kids(int yearsOld, int sex, int salary) {
        super(sex, salary);
        this.yearsOld = yearsOld;
    }

    public void printAge() {
        System.out.println("this kid's age is " + this.yearsOld);
    }

    @Override
    public void employed() {
        System.out.println("kid should go to school and no job");
    }
}
