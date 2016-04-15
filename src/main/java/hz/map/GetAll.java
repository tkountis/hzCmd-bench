package hz.map;

import hz.map.base.MapBench;

import java.util.HashSet;
import java.util.Set;


public class GetAll extends MapBench {

    public int batchSize=100;
    private Set batchKeySet = new HashSet();

    public void init() {
        super.init();

        for(int i =0 ;i<keyDomain; i++){
            int idx = random.nextInt(valueSetSize);
            byte[] v = valueSet.get(idx);
            map.put(i, v);
        }
    }

    public void timeStep() {
        batchKeySet.clear();
        for(int i=0; i<batchSize; i++) {
            int k = random.nextInt(keyDomain);
            batchKeySet.add(k);
        }
        map.getAll(batchKeySet);
    }
}