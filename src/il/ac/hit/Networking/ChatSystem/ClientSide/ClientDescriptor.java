package il.ac.hit.Networking.ChatSystem.ClientSide;

import il.ac.hit.Networking.ChatSystem.StringConsumer;
import il.ac.hit.Networking.ChatSystem.StringProducer;

/**
 * Created by shay on 03/08/2014.
 */
public class ClientDescriptor implements StringConsumer, StringProducer {
    private String nickName;
    private boolean isOnline;
    private StringConsumer stringConsumer;
    private StringProducer stringProducer;

    @Override
    public void addConsumer(StringConsumer messageBoard) {
        stringConsumer = messageBoard;
        stringProducer = (StringProducer)messageBoard;
    }

    @Override
    public void consume(String str) {
        String identifier = str.split(":")[0];
        str = str.split(":")[1];

        if(identifier.equals("NIK")){
                nickName = str;
                str = "New user connected: " + str;
        }
        else if(identifier.equals("MSG")) {
            str = nickName + " : " + str;
        }else if(identifier.equals("DIS")){
            stringProducer.removeConsumer(this);
            str = nickName + " Disconnected!!!";
        }
        stringConsumer.consume(str);
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    @Override
    public void removeConsumer(StringConsumer sc) {
        stringProducer.removeConsumer(sc);

    }
}
