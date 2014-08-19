package il.ac.hit.innerClass;

/**
 * Created by shay on 21/07/2014.
 */
public class CarDemo {
    public static void main(String[] args) {
        Car myCar = new Car("black", "123");
        System.out.println(myCar);
        myCar.getEngine().setSpeed(111);
        System.out.println(myCar);
    }


}
