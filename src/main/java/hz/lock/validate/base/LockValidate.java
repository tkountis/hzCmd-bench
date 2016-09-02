package hz.lock.validate.base;

import com.hazelcast.core.IAtomicLong;
import com.hazelcast.core.IMap;
import hz.lock.base.LockBench;

public abstract class LockValidate extends LockBench {

    public int sleepMs=5;
    private IMap<String, Integer> lockedMap;

    public void init() throws Exception{
        super.init();
        lockedMap = hzInstance.getMap(name);
    }

    public void zeroMapIdx(int i){
        lockedMap.put(name+i, 0);
    }

    public void incMapIdx(int i){
        int val = lockedMap.get(name+i);
        utils.Utils.sleep(sleepMs);
        lockedMap.put(name+i, ++val);
    }

    public int getMapIdx(int i){
        return lockedMap.get(name+i);
    }

    private IAtomicLong getAtomicFor(int i){
        return hzInstance.getAtomicLong(name+i);
    }

    public long getIncrementFor(int i){
        return getAtomicFor(i).get();
    }

    public void addIncrementFor(int i, int increment){
        getAtomicFor(i).addAndGet(increment);
    }

    public String getInfoFor(int i){
        IAtomicLong atomic = getAtomicFor(i);
        return  "atomic "+atomic.getName()+"="+atomic.get()+
                " "+
                "map "+lockedMap.getName()+" at "+name+i+" = "+getMapIdx(i);
    }
}