package hz.atomic.validate.base;

import base.BasicBenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;

import java.util.Random;


public abstract class AtomicValidate extends BasicBenchBase {

    public int count=1;
    public String name;

    private IAtomicLong[] atomicLongs;


    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() throws Exception{
        super.init();

        atomicLongs = new IAtomicLong[count];
        for(int i=0; i<count; i++){
            atomicLongs[i] = hzInstance.getAtomicLong(name+i);
        }
    }

    public IAtomicLong getAtomic(int i){
        return atomicLongs[i];
    }

    private IAtomicLong getExpectedAtomic(int i){
        return hzInstance.getAtomicLong(name+"-expected"+i);
    }

    public long getExpectedIncrement(int i){
        return getExpectedAtomic(i).get();
    }

    public void addExpectedIncrement(int i, long increment){
        getExpectedAtomic(i).addAndGet(increment);
    }

    public String infoStr(int i){
        IAtomicLong atomic = getAtomic(i);
        IAtomicLong expected = getExpectedAtomic(i);

        return  "atomic["+atomic.getName()+"="+atomic.get()+"]"+
                " "+
                "atomic["+expected.getName()+"="+expected.get()+"]";
    }

    public void destroy(){
        for(int i=0; i<count; i++){
            getAtomic(i).destroy();
            getExpectedAtomic(i).destroy();
        }
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }

    public Object getKey(int i){
        return null;
    }

    public Object randomKey(){
        return null;
    }

    public Object mapKeyToValue(int key){
        return null;
    }
}