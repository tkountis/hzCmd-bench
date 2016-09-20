package hz.ops.base;

import base.BasicBenchBase;
import com.hazelcast.core.HazelcastInstance;

public abstract class OpsBase extends BasicBenchBase {

    protected HazelcastInstance hzInstance;

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