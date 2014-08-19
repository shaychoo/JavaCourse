package il.ac.hit.Networking.ChatSystem;

/**
 * Created by shay on 03/08/2014.
 */
public interface StringProducer {
    public void addConsumer(StringConsumer sc);

    public void removeConsumer(StringConsumer sc);
}