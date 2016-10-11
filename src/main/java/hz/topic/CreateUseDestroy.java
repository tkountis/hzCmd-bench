package hz.topic;

import com.hazelcast.core.ITopic;
import hz.set.base.SetBench;

public class CreateUseDestroy extends SetBench {

    public int max=10;

    public void timeStep() {
        ITopic topic = hzInstance.getReliableTopic(name+random.nextInt(max));
        Object val = mapKeyToValue(random.nextInt( keyDomain ));
        topic.publish(val);
        topic.destroy();
    }
}
