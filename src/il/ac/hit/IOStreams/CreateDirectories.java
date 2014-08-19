package il.ac.hit.IOStreams;

import java.io.File;

/**
 * Created by shay on 30/07/2014.
 */
public class CreateDirectories {

    public static void main(String[] args) {
        File file = new File(args[0]);
        boolean succeeded = file.mkdirs();
        if (succeeded) {
            System.out.println("The directories were successfully created");
        } else {
            System.out.println("The directories were not created");
        }
    }

}
