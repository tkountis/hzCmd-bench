package hz.lock.validate.base;

import com.hazelcast.core.IAtomicLong;
import com.hazelcast.core.IMap;
import hz.lock.base.LockBench;

public abstract class LockValidate extends LockBench {

    protected IMap<String, Integer> lockedMap;

    public void init() throws Exception{
        super.init();
        lockedMap = hzInstance.getMap(name);
    }

    public IAtomicLong getIncrementFor(int i){
        return hzInstance.getAtomicLong(name+i);
    }

    public void addIncrementFor(int i, int increment){
        IAtomicLong incTotal = getIncrementFor(i);
        incTotal.addAndGet(increment);
    }
}