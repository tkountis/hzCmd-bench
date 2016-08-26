package hz.ops.base;

import base.BasicBenchBase;
import com.hazelcast.core.HazelcastInstance;

public abstract class OpsBase extends BasicBenchBase {

    protected boolean running=true;
    protected HazelcastInstance hzInstance;

    public void cleanup() {

    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }
}