package hz.ring.base;

import base.BenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.ringbuffer.Ringbuffer;

public abstract class RingBench extends BenchBase {

    public int count=1;
    protected Ringbuffer<Object>[] rings;
    protected HazelcastInstance hzInstance;

    public void init() throws Exception{
        super.init();
        rings = new Ringbuffer[count];
        for (int i = 0; i < count; i++) {
            rings[i] = hzInstance.getRingbuffer(name + i);
        }
    }

    public Ringbuffer getRingBuffer(int i){
        return rings[i];
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }

    @Override
    public String toString() {
        return super.toString() + " RingBench{" + "hzInstance=" + hzInstance + ", rings=" + rings + '}';
    }
}