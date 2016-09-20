package hz.map;

import hz.map.base.MapBench;

import java.util.HashSet;
import java.util.Set;


public class GetAll extends MapBench {

    public int batchSize=100;
    private Set batchKeySet = new HashSet();

    public void timeStep() {
        batchKeySet.clear();
        for(int i=0; i<batchSize; i++) {
            batchKeySet.add(randomKey());
        }
        map.getAll(batchKeySet);
    }
}