package il.ac.hit.Threads;

/**
 * Created by shay on 03/08/2014.
 */
public class KidThread extends Thread {

    @Override
    public void run() {
        System.out.println("run...");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
