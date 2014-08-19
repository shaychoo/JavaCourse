package il.ac.hit.Networking;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by shay on 27/07/2014.
 */
public class ClientSideDemo {


    public static void main(String[] args) {
        Socket socket = null;
        DataOutputStream dos;
        OutputStream os;
        try {
            socket = new Socket("172.16.53.254", 6969);
            os = socket.getOutputStream();
            dos = new DataOutputStream(os);
            dos.writeChars("dsadsa");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
