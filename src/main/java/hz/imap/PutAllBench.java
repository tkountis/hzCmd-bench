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
    private Map putAllMap = new HashMap();

    public int valueSetSize=1000;
    public int valueMinSize=250;
    public int valueMaxSize=6000;

    public List<byte[]> valueSet;

    public void setup(){
        valueSet = dymanicValues(valueSetSize, valueMinSize, valueMaxSize);
        map = hzInstance.getMap(name);
    }

    @Override
    public void timeStep() {
        putAllMap.clear();

        for(int i=0; i<batchSize; i++) {
            int k = random.nextInt(keyDomain);
            int idx = random.nextInt(valueSetSize);
            byte[] v = valueSet.get(idx);
            putAllMap.put(k, v);
        }

        map.putAll(putAllMap);
    }
}