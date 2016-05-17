package hz.ops;

import com.hazelcast.core.HazelcastInstance;
import remote.bench.Bench;

public class ShutDown implements Bench {

    private boolean running=true;
    private HazelcastInstance hzInstance;

    public void init() {

    }

    public void timeStep() throws Exception {
        hzInstance.shutdown();
        running=false;
    }

    public void cleanup() {

    }


    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }

    public boolean isSelfDetermined() {
        return true;
    }

    public boolean isRunning() {
        return running;
    }
}