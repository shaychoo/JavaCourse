package il.ac.hit.Networking.ChatSystem;

import java.util.Vector;

/**
 * Created by shay on 03/08/2014.
 */
public class MessageBoard implements StringConsumer, StringProducer {


    Vector<ConnectionProxy> stringConsumers;


    public MessageBoard() {
        this.stringConsumers = new Vector<ConnectionProxy>();


    }

    @Override
    public void consume(String str) {
        System.out.println(str);
        for (StringConsumer sc : stringConsumers) {
            sc.consume(str);
        }
    }

    @Override
    public void addConsumer(StringConsumer sc) {
        stringConsumers.add((ConnectionProxy) sc);
    }

    @Override
    public void removeConsumer(StringConsumer sc) {
        stringConsumers.remove((ConnectionProxy) sc);
    }
}
