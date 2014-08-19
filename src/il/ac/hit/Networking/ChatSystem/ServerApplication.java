package il.ac.hit.Networking.ChatSystem;

import il.ac.hit.Networking.ChatSystem.ClientSide.ClientDescriptor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by shay on 03/08/2014.
 */
public class ServerApplication {
    public static void main(String args[]) {
        ServerSocket server = null;
        MessageBoard mb = new MessageBoard();
        try {
            server = new ServerSocket(5555, 5);
        } catch (IOException e) {
        }
        Socket socket = null;
        ClientDescriptor client = null;
        ConnectionProxy connection = null;
        while (true) {
            try {
                socket = server.accept();
                connection = new ConnectionProxy(socket);
                client = new ClientDescriptor();
                connection.addConsumer(client);
                client.addConsumer(mb);
                mb.addConsumer(connection);
                connection.start();
            } catch (IOException e) {
            }
        }
    }


}

