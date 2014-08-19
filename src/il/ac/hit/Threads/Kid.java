package il.ac.hit.Threads;

/**
 * Created by shay on 27/07/2014.
 */
public class Kid implements Runnable {
    private String name;

    public Kid(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (double i = 0; i < 100000; i++) {
            System.out.println(name + " " + i + " " + Thread.currentThread().getName());
            /*try {
                Thread.sleep(100);
            }
            catch (InterruptedException e){
                e.getStackTrace();
            }*/
        }


    }


}
