package hz.queue;

import com.hazelcast.core.IAtomicLong;
import com.hazelcast.core.IQueue;
import global.AssertionException;
import hz.queue.base.QueueBench;

public class Assert extends QueueBench {

    public void timeStep() throws AssertionException {

        for (int i = 0; i < queues.length; i++) {
            IQueue q = getQueue(i);
            IAtomicLong offer = hzInstance.getAtomicLong(q.getName()+"-offer");
            IAtomicLong take  = hzInstance.getAtomicLong(q.getName()+"-poll");

            System.out.println(offer.getName() + "=" + offer.get() + " != " + take.getName() + "=" + take.get());
        }


        for (int i = 0; i < queues.length; i++) {
            IQueue q = getQueue(i);
            System.out.println(q.getName()+" size = "+q.size());
        }


        for (int i = 0; i < queues.length; i++) {
            IQueue q = getQueue(i);
            if(q.size() != 0){
                throw new AssertionException(q.getName()+" size = "+q.size()+" != 0");
            }
        }



        for (int i = 0; i < queues.length; i++) {
            IQueue q = getQueue(i);
            IAtomicLong offer = hzInstance.getAtomicLong(q.getName()+"-offer");
            IAtomicLong take  = hzInstance.getAtomicLong(q.getName()+"-poll");

            if(offer.get() != take.get()){
                throw new AssertionException(offer.getName()+"="+offer.get()+" != "+take.getName()+"="+take.get());
            }
        }
        setRunning(false);
    }

}