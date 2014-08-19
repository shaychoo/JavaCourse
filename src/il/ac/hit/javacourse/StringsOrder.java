package il.ac.hit.javacourse;

import java.util.Arrays;

/**
 * Created by shay on 15/07/2014.
 */
public class StringsOrder {
    public static void main(String args[]) {
        String vec[] = {"abc", "aab", "aaa", "zxc", "cxs", "qwe", "gfd", "hjk", "asd"};
        Arrays.sort(vec);
        for (int index = 0; index < vec.length; index++) {
            vec[index].compareTo(vec[index + 1]);


        }

        for (int index = 0; index < vec.length; index++) {
            System.out.println(vec[index]);
        }
    }
}
