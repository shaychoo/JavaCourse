package il.ac.hit.Generics;

import il.ac.hit.innerClass.Line2D;

/**
 * Created by shay on 30/07/2014.
 */
public class ShapeDemo {
    public static void main(String[] args) {
        Shape<Double> d1 = new Shape<Double>();
        Class c1 = d1.getClass();
        Shape<Line2D.Point2D> d2 = new Shape<Line2D.Point2D>();
        Class c2 = d2.getClass();

        System.out.println(d2.a);

        if (c1 == c2)
            System.out.println("OK");
        else
            System.out.println("NO");


    }
}
