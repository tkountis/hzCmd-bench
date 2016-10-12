package hz.topic;

import com.hazelcast.core.ITopic;
import hz.topic.base.TopicBench;

public class CreateUseDestroy extends TopicBench {

    public int max=10;

    private ITopic topic;

    public void timeStep() {

        if(reliable){
            topic = hzInstance.getReliableTopic(name+random.nextInt(max));
        }else{
            topic = hzInstance.getTopic(name+random.nextInt(max));
        }

        Object val = mapKeyToValue(random.nextInt( keyDomain ));
        topic.publish(val);
        topic.destroy();
    }
}
