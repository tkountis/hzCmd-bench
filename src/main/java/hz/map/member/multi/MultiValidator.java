package hz.map.member.multi;

import com.hazelcast.core.IMap;
import hz.map.base.MultiMapBench;
import hz.utils.Utils;

public abstract class MultiValidator extends MultiMapBench {

    public String prefix=null;
    private int key=0;

    public void init() throws Exception{
        super.init();
        Utils.warmupPartitions(hzInstance);
    }

    public void timeStep() throws Exception{

        Object keyObj = getKey(key);
        if(prefix!=null){
            keyObj = prefix + keyObj;
        }

        while(Utils.remoteKey(keyObj, hzInstance)){
            key++;
        }

        if(key >= keyDomain){
            return;
        }


        for (IMap map : getMaps()) {
            Object val = map.get(keyObj);
            validate(keyObj, val);
        }

        key++;
    }

    public abstract void validate(Object key, Object value) throws Exception;

    public boolean isRunning() {
        return key<keyDomain;
    }
}