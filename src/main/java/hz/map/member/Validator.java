package hz.map.member;

import hz.map.base.MapBench;
import hz.utils.Utils;

public abstract class Validator extends MapBench {

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
        Object val = map.get(keyObj);

        validate(key, val);

        key++;
    }

    public abstract void validate(int key, Object value) throws Exception;

    public boolean isRunning() {
        return key<keyDomain;
    }
}