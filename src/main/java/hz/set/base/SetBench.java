package hz.set.base;

import base.BenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ISet;

public abstract class SetBench extends BenchBase {

    public int count=1;
    protected HazelcastInstance hzInstance;
    protected ISet[] sets;

    public void init() throws Exception{
        super.init();

        sets = new ISet[count];
        for (int i = 0; i < count; i++) {
            sets[i] = hzInstance.getSet(name+i);
        }
    }

    public ISet getRandomSet(){
        return getSet(random.nextInt(count));
    }

    public ISet getSet(int i){
        return sets[i];
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }

    @Override
    public String toString() {
        return super.toString() + " SetBench{" + "hzInstance=" + hzInstance + ", set=" + sets + '}';
    }
}