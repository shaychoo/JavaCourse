package il.ac.hit.IOStreams;

import java.io.File;

/**
 * multiple exercise of file handling
 */
public class FileLength {
    public static void main(String[] args) {
        //String filePath = args[0];
        String filePath = "123/1.txt";
        File fileObject = new File(filePath);

        long fileSize = fileObject.length();
        //Check if file exist and delete it, comment rows to use the rest features
        //if(fileObject.exists())
        //     fileObject.delete();

        System.out.println("The size of the file is " + fileSize + " bytes.");

        // Change file timestamp
        long newTimeStamp = System.currentTimeMillis();
        boolean changed = fileObject.setLastModified(newTimeStamp - newTimeStamp / 10);

        String currentDirectory = System.getProperty("user.dir");
        System.out.println("Currend Working Dir:" + currentDirectory);

        if (changed) {
            System.out.println("The time stamp was successfully changed.");
        } else {
            System.out.println("The time stamp was not changed.");
        }

    }
}
