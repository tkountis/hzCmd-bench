package hz.map.listener;


import com.hazelcast.core.EntryEvent;
import com.hazelcast.map.listener.EntryUpdatedListener;

public class EntryUpdateCounter implements EntryUpdatedListener{

    private int updateCount=0;
    private long updateTime=0;

    public void entryUpdated(EntryEvent entryEvent) {
        updateCount++;
        updateTime = System.currentTimeMillis();
    }

    public boolean updatedIn(int seconds){

        long now = System.currentTimeMillis();

        if( (now - updateTime) < (seconds*1000) ){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "EntryUpdateCounter{" +
                "updateCount=" + updateCount +
                ", updateTime=" + updateTime +
                '}';
    }
}