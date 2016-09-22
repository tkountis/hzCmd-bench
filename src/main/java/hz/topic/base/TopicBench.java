package hz.topic.base;

import base.BenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;

public abstract class TopicBench extends BenchBase {

    protected HazelcastInstance hzInstance;
    protected ITopic<Object> topic;

    protected String pubPostFix="-published";
    protected String subPostFix="-subscriber-";

    public void init() throws Exception{
        super.init();
        topic = hzInstance.getReliableTopic(name);
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }

    @Override
    public String toString() {
        return super.toString() + " TopicBench{" + "hzInstance=" + hzInstance + ", topic=" + topic + '}';
    }
}