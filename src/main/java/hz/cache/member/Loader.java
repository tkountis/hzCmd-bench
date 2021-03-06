package hz.cache.member;

import hz.cache.base.CacheBench;
import hz.utils.Utils;

public abstract class Loader extends CacheBench {

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

        cache.put(keyObj, val);

        key++;
    }

    public abstract Object getValue(int key);

    public boolean isRunning() {
        return key<keyDomain;
    }
}