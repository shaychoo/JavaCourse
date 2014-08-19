package il.ac.hit.javacourse;

/**
 * Created by shay on 15/07/2014.
 */
public class ArrayPrint {
    public final static int TOP_LIMIT = 199;
    public final static int BOTTOM_LIMIT = 100;

    public static void main(String[] args) {
        int arraySize = TOP_LIMIT - BOTTOM_LIMIT;
        int[] arr = new int[200];
        for (int i = BOTTOM_LIMIT; i <= TOP_LIMIT; i++) {
            arr[i - BOTTOM_LIMIT] = i;
            System.out.println(i);

        }

    }
}
