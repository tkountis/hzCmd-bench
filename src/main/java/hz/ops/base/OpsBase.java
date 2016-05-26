package hz.ops.base;

import com.hazelcast.core.HazelcastInstance;
import remote.bench.Bench;

public abstract class OpsBase implements Bench {

    protected boolean running=true;
    protected HazelcastInstance hzInstance;

    public void init() {

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