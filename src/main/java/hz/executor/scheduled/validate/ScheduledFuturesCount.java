package hz.executor.scheduled.validate;

import com.hazelcast.scheduledexecutor.IScheduledExecutorService;
import com.hazelcast.scheduledexecutor.IScheduledFuture;
import global.AssertionException;
import hz.executor.scheduled.base.ExecutorBench;

import java.util.List;

public class ScheduledFuturesCount extends ExecutorBench {

    public int scheduleCount=1;
    public boolean validateOnce=false;

    private int counter=0;

    public void timeStep() throws AssertionException {
        System.out.println("Start ScheduledFuturesCount.timeStep() iteration "+counter);

        int totalScheduledFuturesCount=0;
        for (int i = 0; i < executorCount; i++) {


            System.out.println("before getExecutor("+i+");");

            IScheduledExecutorService executor = getExecutor(i);

            System.out.println("after getExecutor("+i+");");




            System.out.println("before executor.getAllScheduledFutures().values()  for loop");


            for (List<IScheduledFuture<Object>> scheduledFuturesPerMember : executor.getAllScheduledFutures().values()) {

                totalScheduledFuturesCount += scheduledFuturesPerMember.size();
                System.out.println("totalScheduledFuturesCount = "+totalScheduledFuturesCount);
            }


            System.out.println("after executor.getAllScheduledFutures().values()  for loop");


        }


        System.out.println("before Assertion");


        int expectedTotal = executorCount * scheduleCount;
        if(totalScheduledFuturesCount != expectedTotal ){
            //throw new AssertionException("total Scheduled Futures Count "+totalScheduledFuturesCount+" != "+expectedTotal);
            System.out.println("total Scheduled Futures Count "+totalScheduledFuturesCount+" != "+expectedTotal);
        }


        System.out.println("after Assertion");


        if(validateOnce==true){
            setRunning(false);
            System.out.println("setRunning(false);");
        }



        System.out.println("End ScheduledFuturesCount.timeStep() iteration "+counter);


        counter++;
    }
}
