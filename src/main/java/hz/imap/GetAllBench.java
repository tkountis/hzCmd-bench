package hz.imap;

import com.hazelcast.core.IMap;
import vendor.hz.HzBench;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.Utils.dymanicValues;

public class GetAllBench extends HzBench {

    private IMap map;
    public String name;

    public int keyDomain=10000;

    public int batchSize=10;
    private Set batchKeySet = new HashSet();

    public int valueSetSize=1000;
    public int valueMinSize=250;
    public int valueMaxSize=6000;

    public List<byte[]> valueSet;

    public void setup(){
        valueSet = dymanicValues(valueSetSize, valueMinSize, valueMaxSize);
        map = hzInstance.getMap(name);

        for(int i=0 ;i<keyDomain; i++){
            int idx = random.nextInt(valueSetSize);
            byte[] v = valueSet.get(idx);
            map.put(i, v);
        }
    }

    @Override
    public void timeStep() {
        batchKeySet.clear();
        for(int i=0; i<batchSize; i++) {
            int k = random.nextInt(keyDomain);
            batchKeySet.add(k);
        }

        map.getAll(batchKeySet);
    }
}