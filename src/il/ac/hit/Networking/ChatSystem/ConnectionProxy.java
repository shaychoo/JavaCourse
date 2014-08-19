package il.ac.hit.Networking.ChatSystem;

import java.io.*;
import java.net.Socket;

/**
 * Created by shay on 03/08/2014.
 */

public class ConnectionProxy extends Thread implements StringConsumer, StringProducer {


    private Socket socket;
    private InputStream is;
    private OutputStream os;
    private DataInputStream dis;
    private DataOutputStream dos;
    private StringConsumer sc;
    private StringProducer sp;

    public ConnectionProxy(Socket s) {

        try {
            socket = s;
            is = socket.getInputStream();
            dis = new DataInputStream(is);
            os = socket.getOutputStream();
            dos = new DataOutputStream(os);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void consume(String str) {
        try {
            dos.writeUTF(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addConsumer(StringConsumer stringConsumer) {
        sc = stringConsumer;
        sp = (StringProducer) stringConsumer;
    }

    @Override
    public void removeConsumer(StringConsumer sc) {
        this.sc = null;
    }

    @Override
    public void run() {

        try {
            while (true) {

                String message = dis.readUTF();
                String identifier = message.split(":")[0];
                if (identifier.equals("DIS")) {
                    sp.removeConsumer(this);
                    return;

                } else
                    sc.consume(message);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
