package il.ac.hit.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shay on 27/07/2014.
 */
public class KidDemo {

    public static void main(String[] args) {
        Kid k1 = new Kid("bob");
        Kid k2 = new Kid("marly");

        Thread t1 = new Thread(k1);
        Thread t2 = new Thread(k1);
        k1.run();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Thread Pull
        ExecutorService pull  = Executors.newFixedThreadPool(3);
        //pull.submit(Runabl Object)

        k1.run();


        t1.start();
        t2.start();

    }
}
