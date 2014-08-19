package il.ac.hit.Lambda;

/**
 * Created by shay on 17/08/2014.
 */
public class LambdaTest {
    public static void main(String... args)
    {
        LambdaTest myApp =
                new LambdaTest();
        Utils utils = new Utils();
      //  MathOperation op = utils::calcu;
       // int num = op.execute(40, 2);
        //System.out.println("40 * 2 = " + num);
    }
    interface MathOperation {
        int execute(int a, int b);
    }
}
class Utils
{
    public int calcu(int a,int b)
    {
        System.out.println("calcu is called");
        return a*b;
    }
}





