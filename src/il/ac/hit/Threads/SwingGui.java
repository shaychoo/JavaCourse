package il.ac.hit.Threads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by shay on 03/08/2014.
 */
public class SwingGui {
    public JPanel p1, p2, p3;
    private JFrame frame;
    private JButton bt1, bt2;
    private JTextField tf1, tf2, tf3;

    public SwingGui() {
        this.frame = new JFrame();

        this.bt2 = new JButton("-");
        this.tf1 = new JTextField(10);
        this.tf2 = new JTextField(10);
        this.tf3 = new JTextField(10);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {

                        SwingGui demo = new SwingGui();
                        demo.start();

                    }

                }
        );

    }

    public void start() {
        frame.setLayout(new BorderLayout());

        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p2 = new JPanel();
        p2.setLayout(new FlowLayout());

        frame.add(BorderLayout.NORTH, p1);
        frame.add(BorderLayout.SOUTH, p2);


        //frame.add(BorderLayout.WEST,tf2);
        p1.add(tf3);
        p1.add(new JButton("+"));
        p1.add(tf2);


        p2.add(new JButton("+"));
        p2.add(new JButton("+"));
        p2.add(new JButton("+"));


        frame.setSize(300, 300);
        frame.setVisible(true);


        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


    }


}
