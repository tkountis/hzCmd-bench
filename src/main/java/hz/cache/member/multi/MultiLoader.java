package hz.cache.member.multi;

import com.hazelcast.cache.ICache;
import hz.cache.base.MultiCacheBench;
import hz.utils.Utils;

public abstract class MultiLoader extends MultiCacheBench {

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

        for (ICache cache : getCaches()) {
            cache.put(keyObj, val);
        }

        key++;
    }

    public abstract Object getValue(int key);

    public boolean isRunning() {
        return key<keyDomain;
    }
}