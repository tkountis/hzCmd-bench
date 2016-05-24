package hz.map.member;

import hz.map.base.MapBench;
import hz.utils.Utils;

public abstract class Loader extends MapBench {

    public int asyncBatch=1000;
    private int putCount=0;
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

        if(putCount%asyncBatch==0) {
            map.set(key, val);
        }else{
            map.putAsync(key, val);
        }
        putCount++;
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
        System.out.println("map "+map.getName()+" size="+map.size());
    }
}