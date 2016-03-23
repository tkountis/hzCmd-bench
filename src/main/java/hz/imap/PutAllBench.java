package hz.imap;

import com.hazelcast.core.IMap;
import vendor.hz.HzBench;

import java.util.*;

import static utils.Utils.dymanicValues;

public class PutAllBench extends HzBench {

    private IMap map;
    public String name;

    public int keyDomain=10000;

    public int batchSize=10;

    public int valueSetSize=1000;
    public int valueSize=0;

    public int valueMinSize=250;
    public int valueMaxSize=6000;

    public List<byte[]> valueSet;

    public void setup(){

        if(valueSize!=0){
            valueSet = dymanicValues(valueSetSize, valueSize, valueSize);
        }else{
            valueSet = dymanicValues(valueSetSize, valueMinSize, valueMaxSize);
        }
        map = hzInstance.getMap(name);
    }

    @Override
    public void timeStep() {

        Map putAllMap = new HashMap();
        //putAllMap.clear();

        for(int i=0; i<batchSize; i++) {
            int k = random.nextInt(keyDomain);
            int idx = random.nextInt(valueSetSize);
            byte[] v = valueSet.get(idx);
            putAllMap.put(k, v);
        }

        map.putAll(putAllMap);
    }
}