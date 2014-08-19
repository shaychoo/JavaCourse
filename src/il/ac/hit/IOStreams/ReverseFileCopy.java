package il.ac.hit.IOStreams;

import java.io.*;

/**
 * Created by shay on 27/07/2014.
 */
public class ReverseFileCopy {
    public static void main(String[] args) {

        try {
            File inFile = new File("1.txt");
            File outFile = new File("2.txt");
            FileInputStream fis = new FileInputStream(inFile);
            FileOutputStream fos = new FileOutputStream(outFile);

            int fileSize = (int) inFile.length();
            byte[] tmp = new byte[fileSize];

            fis.read(tmp);

            for (int i = fileSize - 1; i >= 0; i--) {
                fos.write(tmp[i]);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
