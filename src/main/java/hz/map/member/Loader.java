package hz.map.member;

import hz.map.base.MapBench;
import hz.utils.Utils;

public abstract class Loader extends MapBench {


    public String prefix=null;
    private int key=0;

    public void init() throws Exception{
        super.init();
        Utils.warmupPartitions(hzInstance);
    }

    public void timeStep() {

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

        Object val = getValue(key);

        map.set(keyObj, val);

        key++;
    }

    public abstract Object getValue(int key);

    public boolean isRunning() {
        return key<keyDomain;
    }
}