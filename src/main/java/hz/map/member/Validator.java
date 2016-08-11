package hz.map.member;

import hz.map.base.MapBench;
import hz.utils.Utils;

public abstract class Validator extends MapBench {

    private int key=0;

    public void init() throws Exception{
        super.init();
        Utils.warmupPartitions(hzInstance);
    }

    public void timeStep() throws Exception{
        while(Utils.remoteKey(key, hzInstance)){
            key++;
        }

        if(key >= keyDomain){
            return;
        }

        Object val = map.get(key);

        validate(key, val);

        key++;
    }

    public abstract void validate(int key, Object value) throws Exception;

    public boolean isRunning() {
        return key<keyDomain;
    }

    public boolean isSelfDetermined() {
        return true;
    }

    public void cleanup() {
        System.out.println("load map "+map.getName()+" size="+map.size());
    }
}