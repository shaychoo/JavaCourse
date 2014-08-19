package il.ac.hit.Networking;

/**
 * Created by shay on 03/08/2014.
 */

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleTCPIPServer {
    public static void main(String[] args) {
        //once this server is up and running you can call it
        //using telnet: "telnet 127.0.0.1 8070"

        int port = 8070;

        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
        }
        if (port <= 0 || port >= 65536) port = 8070;

        try {
            ServerSocket ss = new ServerSocket(8070);
            while (true) {
                OutputStream out = null;
                Socket socket = null;
                try {
                    socket = ss.accept();

                    String response = "Hello " + socket.getInetAddress()
                            + " on port "
                            + socket.getPort()
                            + "\r\n";
                    response += "This is " + socket.getLocalAddress()
                            + " on port "
                            + socket.getLocalPort()
                            + "\r\n";

                    out = socket.getOutputStream();

                    out.write(response.getBytes());

                    out.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException e) {
                        }
                    }
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
