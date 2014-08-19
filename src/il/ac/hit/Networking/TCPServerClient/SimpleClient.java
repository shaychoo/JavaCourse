package il.ac.hit.Networking.TCPServerClient;

/**
 * Created by shay on 02/08/2014.
 */

import java.io.*;
import java.net.Socket;

public class SimpleClient {
    public static String serverName = "127.0.0.1";
    public static int serverPortNumber = 1300;

    public static void main(String args[]) {
        Socket socket = null;
        InputStream is = null;
        DataInputStream dis = null;
        OutputStream os = null;
        DataOutputStream dos = null;

        try {

            socket = new Socket(serverName, serverPortNumber);
            // System.out.println("socket was created...");
            is = socket.getInputStream();
            // System.out.println("input stream was created...");
            dis = new DataInputStream(is);
            // System.out.println("data input stream was created...");
            os = socket.getOutputStream();
            //System.out.println("output stream was created...");
            dos = new DataOutputStream(os);
            //System.out.println("data output stream was created...");
            while (true) {
                System.out.print("Client:");
                String s = System.console().readLine();
                dos.writeUTF(s);

                // System.out.println(args[0] + " was written to the server...");
                System.out.println("Server: " + dis.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
