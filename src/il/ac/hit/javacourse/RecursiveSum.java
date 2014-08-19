package il.ac.hit.javacourse;

/**
 * Created by shay on 13/07/2014.
 */
public class RecursiveSum {

    public static int DoSum(int[] arr, int n) {
        if (n == 0)
            return 0;

        return DoSum(arr, n - 1) + arr[n - 1];
    }


    public static void main(String[] arrg) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(DoSum(arr, 5));

    }

}
