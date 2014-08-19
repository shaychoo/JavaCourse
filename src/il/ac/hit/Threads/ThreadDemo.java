package il.ac.hit.Threads;

/**
 * Created by shay on 03/08/2014.
 */
public class ThreadDemo {
    public static void main(String[] args) {


        KidThread k1 = new KidThread();
        KidThread k2 = new KidThread();
        k1.start();
        k2.start();
    }
}
