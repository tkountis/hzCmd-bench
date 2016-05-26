package hz.ops;

import com.hazelcast.core.HazelcastInstance;
import remote.bench.Bench;

public class ThrowException implements Bench {

    private boolean running=true;
    private HazelcastInstance hzInstance;

    public void init() {

    }

    public void timeStep() throws Exception {
        running=false;
        throw new java.lang.Exception("ThrowException Requested");
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