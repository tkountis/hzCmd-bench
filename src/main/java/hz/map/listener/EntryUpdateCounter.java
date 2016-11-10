package hz.map.listener;


import com.hazelcast.core.EntryEvent;
import com.hazelcast.map.listener.EntryUpdatedListener;

import java.util.concurrent.atomic.AtomicInteger;

import static utils.Utils.sleep;

public class EntryUpdateCounter implements EntryUpdatedListener{

    private AtomicInteger updateCount = new AtomicInteger(0);
    private long updateTime=0;

    public void entryUpdated(EntryEvent entryEvent) {
        updateCount.incrementAndGet();
        updateTime = System.currentTimeMillis();
    }

    public boolean updatedIn(int seconds){
        int before = updateCount.get();
        sleep(seconds*1000);
        if(before == updateCount.get()){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntryUpdateCounter{" +
                "updateCount=" + updateCount +
                ", updateTime=" + updateTime +
                '}';
    }
}