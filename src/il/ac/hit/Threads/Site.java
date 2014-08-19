package il.ac.hit.Threads;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by shay on 27/07/2014.
 */
public class Site {
    public static void main(String[] args) {
        InputStream in = null;
        try {
            URL url = new URL("http://google.com");
            try {
                in = url.openStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int tmp = in.read();
            while (tmp != -1) {
                System.out.print((char) tmp);
                tmp = in.read();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
