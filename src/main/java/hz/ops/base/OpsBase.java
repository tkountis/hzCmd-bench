package hz.ops.base;

import base.BasicBenchBase;
import com.hazelcast.core.HazelcastInstance;

public abstract class OpsBase extends BasicBenchBase {

    protected boolean running=true;
    protected HazelcastInstance hzInstance;

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }

    public boolean isRunning() {
        return running;
    }

    public boolean isSelfDetermined() {
        return true;
    }
}