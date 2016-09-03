package hz.atomic.validate;

import com.hazelcast.core.IAtomicLong;
import hz.atomic.validate.base.AtomicValidate;

public class Cas extends AtomicValidate {

    private long[] increments;

    public void init() throws Exception{
        super.init();
        increments = new long[count];
    }

    public void timeStep() {
        int i = random.nextInt(count);
        IAtomicLong atomic = getAtomic(i);
        long val = atomic.get();
        if ( atomic.compareAndSet(val, ++val) ){
            increments[i]++;
        }
    }

    public void postPhase() {
        for(int i=0; i<count; i++){
            addExpectedIncrement(i, increments[i]);
        }
    }
}
