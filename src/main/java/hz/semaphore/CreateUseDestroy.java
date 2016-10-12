package hz.semaphore;

import com.hazelcast.core.ISemaphore;
import hz.semaphore.base.SemaphoreBench;

public class CreateUseDestroy extends SemaphoreBench {

    public int max=10;

    public void timeStep() {
        ISemaphore semaphore = hzInstance.getSemaphore(name+random.nextInt(max));
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {}
        semaphore.release();
        semaphore.destroy();
    }
}
