package hz.topic;

import global.AssertionException;
import hz.topic.base.TopicBench;

public class PubSubAssert extends TopicBench {

    public int subCount=0;

    public void timeStep() throws AssertionException {

        String topixName = name+pubPostFix;
        long publishedCount = hzInstance.getAtomicLong(topixName).get();

        for (int i = 0; i < subCount; i++) {
            String subName = name+subPostFix+i;
            long recivedCount = hzInstance.getAtomicLong(subName).get();

            System.out.println(topixName+"="+publishedCount+" != "+subName+"="+recivedCount);

            if(publishedCount != recivedCount){
                throw new AssertionException(topixName+"="+publishedCount+" != "+subName+"="+recivedCount);
            }
        }
        setRunning(false);
    }

}