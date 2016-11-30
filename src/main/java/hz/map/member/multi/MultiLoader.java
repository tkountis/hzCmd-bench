package hz.map.member.multi;

import com.hazelcast.core.IMap;
import hz.map.base.MultiMapBench;
import hz.utils.Utils;

public abstract class MultiLoader extends MultiMapBench {

    private int key=0;

    public void init() throws Exception{
        super.init();
        Utils.warmupPartitions(hzInstance);
    }

    public void timeStep() {
        while(Utils.remoteKey(key, hzInstance)){
            key++;
        }

        if(key >= keyDomain){
            return;
        }

        Object keyObj = getKey(key);
        Object val = getValue(key);

        for (IMap map : getMaps()) {
            map.put(keyObj, val);
        }

        key++;
    }

    public abstract Object getValue(int key);

    public boolean isRunning() {
        return key<keyDomain;
    }
}