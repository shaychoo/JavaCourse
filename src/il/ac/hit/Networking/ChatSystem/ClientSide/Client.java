package il.ac.hit.Networking.ChatSystem.ClientSide;

import il.ac.hit.Networking.ChatSystem.ConnectionProxy;
import il.ac.hit.Networking.ChatSystem.StringConsumer;
import il.ac.hit.Networking.ChatSystem.StringProducer;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by shay on 03/08/2014.
 */
public class Client implements StringConsumer, StringProducer {
    public static final String _ipAddress = "127.0.0.1";
    public static final int _port = 5555;

    public JPanel p1, p2, p3;

    private JFrame frame;
    private JButton sendButton, connectButton;
    private JTextField msgToSend, nickName;
    private JTextArea chatRoom;
    private ConnectionProxy connectionProxy;
    private String _nickName;
    private StringConsumer sc;

    public Client() {

        InitClientGui();
        setActionListeners();
    }

    public static void main(String[] args) {
        Client c = new Client();
    }


    private boolean connect() {
        try {
            connectionProxy = new ConnectionProxy(new Socket(_ipAddress, _port));
            addConsumer(connectionProxy);
            connectionProxy.addConsumer(this);

            return true;

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fail to connect the server!");
            //e.printStackTrace();
            return false;
        }

    }
    private  void disconnect(){
        sc.consume("DIS:");
    }

    private void setActionListeners() {
        ActionListener sendMsgListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                sc.consume("MSG:" + msgToSend.getText());
                msgToSend.setText("");
            }
        };
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (connectButton.getText().equals("Connect")) {
                    if (connect()) {
                        _nickName = nickName.getText();
                        nickName.setEnabled(false);

                        sc.consume("NIK:" + _nickName);
                        connectionProxy.start();

                        sendButton.setEnabled(true);
                        connectButton.setText("Disconnect");
                    }
                } else {
                    disconnect();
                    nickName.setEnabled(true);
                    sendButton.setEnabled(false);
                    connectButton.setText("Connect");

                }
            }
        });

        // Action listeners for pressing "Send" button or Enter
        sendButton.addActionListener(sendMsgListener);
        msgToSend.addActionListener(sendMsgListener);


    }


    @Override
    public void consume(String str) {
        chatRoom.append(str + "\n");
    }

    @Override
    public void addConsumer(StringConsumer stringConsumer) {
        sc = stringConsumer;
    }

    @Override
    public void removeConsumer(StringConsumer stringConsumer) {
        stringConsumer = null;
    }

    private void InitClientGui() {
        p1 = new JPanel(new FlowLayout());
        p2 = new JPanel(new FlowLayout());
        p3 = new JPanel(new FlowLayout());
        sc = this;

        nickName = new JTextField(10);
        nickName.setText("Client");
        msgToSend = new JTextField(10);


        sendButton = new JButton("Send");
        sendButton.setEnabled(false);
        connectButton = new JButton("Connect");
        connectButton.setBackground(new Color(0, 255, 0).brighter());

        chatRoom = new JTextArea(20, 30);
        JScrollPane scrollBars = new JScrollPane(chatRoom, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        DefaultCaret caret = (DefaultCaret)chatRoom.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        //frame.getContentPane().add(scrollBars);
        chatRoom.append("Welcome to the best Chat \n");
        chatRoom.append("----------------------------------------------- \n");
        //chatRoom.append("Connecting...");

        chatRoom.setEditable(false);

        frame = new JFrame("Chat Client");
        frame.setLayout(new BorderLayout());
        frame.add(BorderLayout.NORTH, p1);
        frame.add(BorderLayout.CENTER, p2);
        frame.add(BorderLayout.SOUTH, p3);

        p1.add(new JLabel("Nick name: "));
        p1.add(nickName);
        p1.add(connectButton);

        p2.add(scrollBars);


        p3.add(new JLabel("Message: "));
        p3.add(msgToSend);
        p3.add(sendButton);

        frame.setSize(400, 450);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                disconnect();
                System.exit(0);
            }
        });

    }
}
