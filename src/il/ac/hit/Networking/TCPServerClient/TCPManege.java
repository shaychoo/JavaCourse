package il.ac.hit.Networking.TCPServerClient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by shay on 02/08/2014.
 */
public class TCPManege {
    public static String serverName = "127.0.0.1";
    public static int serverPortNumber = 1300;
    public ServerSocket server = null;
    private Socket socket = null;
    private InputStream is = null;
    private DataInputStream dis = null;
    private OutputStream os = null;
    private DataOutputStream dos = null;


    public TCPManege() {
        try {
            server = new ServerSocket(serverPortNumber);

            is = socket.getInputStream();
            dis = new DataInputStream(is);
            os = socket.getOutputStream();
            dos = new DataOutputStream(os);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
