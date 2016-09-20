package gg.atomic.base;

import base.BasicBenchBase;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteAtomicLong;

import java.util.Random;

public abstract class AtomicBench extends BasicBenchBase {

    public String name="atomic";
    public int count=1;

    protected Ignite ignite;
    protected IgniteAtomicLong[] atomicLongs;
    protected Random random = new Random();


    public void init() throws Exception{
        super.init();

        atomicLongs = new IgniteAtomicLong[count];
        for(int i=0; i< count; i++){
            atomicLongs[i] = ignite.atomicLong(name+i, 0, true);
        }
    }

    protected IgniteAtomicLong getAtomic(){
        return atomicLongs[random.nextInt(count)];
    }

    public void setVendorObject(Object vendorObject) { ignite = (Ignite) vendorObject; }

    public Object getKey(int i){
        return null;
    }

    public Object randomKey(){
        return null;
    }

    public Object mapKeyToValue(int key){ return null; }

}