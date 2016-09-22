package hz.topic;

import hz.topic.base.TopicBench;

public class Publisher extends TopicBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        Object val = mapKeyToValue(k);

        topic.publish(val);
    }
}
