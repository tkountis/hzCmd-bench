package hz.topic;

import hz.topic.base.TopicBench;

public class Subscriber extends TopicBench {

    private MsgCounter counter = new MsgCounter();

    public void init() throws Exception{
        super.init();
        topic.addMessageListener(counter);
    }

    public void timeStep() throws InterruptedException {
        Thread.sleep(1);
    }

    public void postPhase() {
        hzInstance.getAtomicLong(name).addAndGet(counter.getCount());
    }
}

