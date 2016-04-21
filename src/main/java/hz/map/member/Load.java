package hz.map.member;

import hz.map.base.MapBench;
import hz.utils.Utils;

public class Load extends MapBench {

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

        int idx = random.nextInt(valueSet.size());
        Object val = valueSet.get(idx);

        if(putCount%asyncBatch==0) {
            map.put(key, val);
        }else{
            map.putAsync(key, val);
        }
        putCount++;
        key++;
    }

    public boolean isRunning() {
        return key<keyDomain;
    }

    public boolean isSelfDetermined() {
        return true;
    }

    public void cleanup() {
    }
}