package hz.topic;

import global.AssertionException;
import hz.topic.base.TopicBench;

public class PubSubAssert extends TopicBench {

    public void timeStep() throws AssertionException {

        String topixName = name+pubPostFix;
        long publishedCount = hzInstance.getAtomicLong(topixName).get();

        long subCount = hzInstance.getAtomicLong(name).get();

        for (int i = 0; i < subCount; i++) {
            String subName = name+subPostFix+i;
            long recivedCount = hzInstance.getAtomicLong(subName).get();

            if(publishedCount != recivedCount){
                throw new AssertionException(topixName+"="+publishedCount+" != "+subName+"="+recivedCount);
            }
        }
        setRunning(false);
    }

}