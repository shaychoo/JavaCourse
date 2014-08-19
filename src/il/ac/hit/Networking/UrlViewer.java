package il.ac.hit.Networking;

/**
 * Created by shay on 01/08/2014.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class UrlViewer {
    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("You should pass the URL address you want to view...");
        } else {
            InputStream in = null;
            try {
                URL url = new URL(args[0]);
                in = url.openStream();
                File f = new File("c://1.html");
                FileOutputStream fos = new FileOutputStream(f);
                IOUtils.streamCopy(in, fos);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


