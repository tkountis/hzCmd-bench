package hz.map.validate.base;

import com.hazelcast.core.IAtomicLong;
import hz.map.base.MapBench;

public abstract class LockValidate extends MapBench {

    public int sleepMs=5;


    public void incMapIdx(int i){
        int val = (Integer) map.get(i);
        utils.Utils.sleep(sleepMs);
        map.put(i, ++val);
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
        return  "atomic["+atomic.getName()+"="+atomic.get()+"]"+
                " "+
                "map["+map.getName()+".get("+i+")="+map.get(i)+"]";
    }
}