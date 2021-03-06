package il.ac.hit.Networking.TCPServerClient;

/**
 * Created by shay on 02/08/2014.
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static String serverName = "127.0.0.1";
    public static int serverPortNumber = 1300;

    public static void main(String args[]) {
        Socket socket = null;
        ServerSocket server = null;
        InputStream is = null;
        DataInputStream dis = null;
        OutputStream os = null;
        DataOutputStream dos = null;

        try {
            server = new ServerSocket(serverPortNumber);
            while (true) {
                System.out.println("Ready...");
                socket = server.accept();
                is = socket.getInputStream();
                dis = new DataInputStream(is);
                os = socket.getOutputStream();
                dos = new DataOutputStream(os);
                String number = String.valueOf(dis.read());
                dis.readUTF();
                System.out.println("dis.readUTF() returns " + number);
                String reply = "You should send the server one of the following numbers: 1,2 or 3";
                if (number.equals("1")) {
                    reply = "one";
                } else if (number.equals("2")) {
                    reply = "two";
                } else if (number.equals("3")) {
                    reply = "three";
                }
                System.out.println("dos.writeUTF(\"" + reply + "\")");
                dos.writeUTF(reply);
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
