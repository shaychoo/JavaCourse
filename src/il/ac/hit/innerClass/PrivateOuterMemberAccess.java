package il.ac.hit.innerClass;

/**
 * Created by shay on 21/07/2014.
 */
public class PrivateOuterMemberAccess {
    private int num1;

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public PrivateOuterMemberAccess(int num1) {
        this.num1 = num1;
    }

    class inner {
    private int num2;

        public int getNum2() {
            return num2;
        }

        public void setNum2(int num2) {
            this.num2 = num2;
        }

        public void printOuterNum1() {
            System.out.println(num1);
        }
    }
}


class PrivateInnerMemberAccess {
    inner innerOb;

    PrivateInnerMemberAccess() {
        innerOb = new inner(2);
    }

    public void printInnerNum1() {
        System.out.println(innerOb.num1);
    }

    class inner {

        private int num1;

        inner(int num1) {
            this.num1 = num1;
        }
    }
}
