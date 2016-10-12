package hz.semaphore;

import com.hazelcast.core.ISemaphore;
import hz.semaphore.base.SemaphoreBench;

/**
 * Created by danny on 12/05/2016.
 */
public class CreateDestroy extends SemaphoreBench {
    public void timeStep() {
        ISemaphore semaphore = hzInstance.getSemaphore(name+random.nextInt());
        semaphore.destroy();
    }
}
