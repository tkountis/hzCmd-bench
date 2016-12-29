package hz.queue;

import com.hazelcast.core.IQueue;
import hz.queue.base.QueueBench;

import java.util.concurrent.TimeUnit;

public class Poll extends QueueBench {

    public int pauseForEvents=30000;
    public int timeOutMillis=10;
    private long[] pollPerQ;

    public void init() throws Exception{
        super.init();
        pollPerQ = new long[count];
    }

    public void timeStep() throws InterruptedException {

        int queueIdx = random.nextInt(count);
        IQueue q = getQueue(queueIdx);

        if(q.poll(timeOutMillis, TimeUnit.MILLISECONDS) != null) {
            pollPerQ[queueIdx]++;
        }
    }

    public void postPhase() {

        /*
        * try {
            Thread.sleep(pauseForEvents);

            for (int i = 0; i < queues.length; i++) {
                IQueue q = getQueue(i);
                while (q.poll(timeOutMillis, TimeUnit.MILLISECONDS) != null) {
                    pollPerQ[i]++;
                }
            }
          }catch (Exception ignore){}
        * */


        try {
            Thread.sleep(pauseForEvents);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < queues.length; i++) {
            IQueue q = getQueue(i);

            Object res=null;
            do{
                try {
                    res = q.poll(timeOutMillis, TimeUnit.MILLISECONDS);
                    if(res!=null){
                        pollPerQ[i]++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while(res != null);

            System.out.println(q.getName()+" size = "+q.size());
        }


        for (int i = 0; i < queues.length; i++) {
            IQueue q = getQueue(i);
            hzInstance.getAtomicLong(q.getName()+"-poll").addAndGet(pollPerQ[i]);
        }
    }
}
