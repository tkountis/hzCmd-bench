package hz.semaphore;

import com.hazelcast.core.ISemaphore;
import hz.semaphore.base.SemaphoreBench;


public class Semaphore extends SemaphoreBench {

    public void timeStep() {
        ISemaphore semaphore = getSemaphore();
        try {
            semaphore.acquire();
        } catch (InterruptedException e){}
        semaphore.release();
    }
}
