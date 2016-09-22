package hz.topic;

import hz.topic.base.TopicBench;

public class Publisher extends TopicBench {

    private long count=0;

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        Object val = mapKeyToValue(k);

        topic.publish(val);
        count++;
    }

    public void postPhase() {
        hzInstance.getAtomicLong(name+pubPostFix).addAndGet(count);
    }
}
