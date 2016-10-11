package hz.repmap;

import com.hazelcast.core.ReplicatedMap;
import hz.queue.base.QueueBench;

public class CreateUseDestroy extends QueueBench {

    public int max=10;

    public void timeStep() {
        ReplicatedMap map = hzInstance.getReplicatedMap(name+random.nextInt(max));
        int k = random.nextInt(keyDomain);
        Object key = getKey(k);
        Object val = mapKeyToValue(k);
        map.put(key, val);
        map.destroy();
    }
}
