package hz.atomic;

import com.hazelcast.core.IAtomicLong;
import hz.atomic.base.AtomicBench;

/**
 * Created by danny on 12/05/2016.
 */
public class CreateDestroy extends AtomicBench{
    public void timeStep() {
        IAtomicLong atomic = hzInstance.getAtomicLong(name+random.nextInt());
        atomic.destroy();
    }
}
