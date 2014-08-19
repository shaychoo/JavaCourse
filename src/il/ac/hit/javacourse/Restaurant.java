package il.ac.hit.javacourse;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by shay on 13/07/2014.
 */
public class Restaurant {
    public static void main(String args[]) {
        Food vec[] = new Food[10];
        Random selectFood = new Random();
        for (int index = 0; index < vec.length; index++) {

            switch (selectFood.nextInt(3)) {
                case 0:
                    vec[index] = new Pizza();
                    break;
                case 1:
                    vec[index] = new Humborger();
                    break;
                case 2:
                    vec[index] = new Falafel();
                    break;
            }


        }

        Arrays.sort(vec);

        for (int index = 0; index < vec.length; index++) {
            System.out.println(vec[index]);
        }
    }
}