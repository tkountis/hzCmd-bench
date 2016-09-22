package hz.topic;

import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;

public class MsgCounter implements MessageListener<Object> {

    private long count=0;

    public void onMessage(Message<Object> message) {
        synchronized(this){
            count++;
            notify();
        }
    }

    public long getCount() {
        return count;
    }
}
