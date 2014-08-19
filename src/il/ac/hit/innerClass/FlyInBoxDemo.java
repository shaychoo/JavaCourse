package il.ac.hit.innerClass;

/**
 * Created by shay on 21/07/2014.
 */
public class FlyInBoxDemo {

    public static void main(String[] args) {
        Box box = new Box(10, 10, 10);
        box.fly.setX(9);
        System.out.println(box);

        box.fly.setX(20);
        System.out.println(box);

    }
}
