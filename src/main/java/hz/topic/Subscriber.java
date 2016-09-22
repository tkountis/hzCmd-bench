package hz.topic;

import hz.topic.base.TopicBench;

public class Subscriber extends TopicBench {

    public int pauseForEvents=10000;

    private MsgCounter counter = new MsgCounter();

    public void init() throws Exception{
        super.init();
        topic.addMessageListener(counter);
    }

    public void timeStep() throws InterruptedException {
        //Thread.sleep(1);
        synchronized(counter){
            counter.wait();
        }
    }

    public void postPhase() {
        try {
            Thread.sleep(pauseForEvents);
        }catch (Exception ignore){}

        long subCount = hzInstance.getAtomicLong(name).getAndAdd(1);
        hzInstance.getAtomicLong(name+subPostFix+subCount).set(counter.getCount());
    }
}

