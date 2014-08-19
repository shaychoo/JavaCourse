package il.ac.hit.innerClass;

/**
 * Created by shay on 21/07/2014.
 */
public class PrivateMemberAccessDemo {
    public static void main(String[] args) {
        PrivateInnerMemberAccess ob = new PrivateInnerMemberAccess();
        ob.printInnerNum1();

        PrivateOuterMemberAccess ob2 = new PrivateOuterMemberAccess(1);
        PrivateOuterMemberAccess.inner a = ob2.new inner();
        PrivateOuterMemberAccess.inner b = ob2.new inner();

            a.setNum2(3);

        System.out.println(b.getNum2());





    }
}
