package il.ac.hit.javacourse;

import java.util.Arrays;

/**
 * Created by shay on 15/07/2014.
 */
public class NumbersOrder {
    public static void main(String args[]) {
        int vec[] = {1, 2, 3, 65, 23, 78, 5, 2, 1, 234, 23, 21, 2, 23, 323, 1111, 21};
        Arrays.sort(vec);

        for (int index = 0; index < vec.length; index++) {
            System.out.println(vec[index]);
        }
    }
}