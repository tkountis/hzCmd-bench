package hz.cache.member;

import hz.cache.base.CacheBench;
import hz.map.base.MapBench;
import hz.utils.Utils;

public abstract class Loader extends CacheBench {

    private int key=0;

    public void init(){
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

        Object val = getValue(key);

        cache.put(key, val);

        key++;
    }

    public abstract Object getValue(int key);

    public boolean isRunning() {
        return key<keyDomain;
    }

    public boolean isSelfDetermined() {
        return true;
    }

    public void cleanup() {
        System.out.println("load cache "+cache.getName()+" size="+cache.size());
    }
}