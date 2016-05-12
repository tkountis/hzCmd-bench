package hz.cache;

import gg.cache.base.CacheBench;

import java.util.HashSet;
import java.util.Set;


public class GetAll extends CacheBench {

    public int batchSize=100;
    private Set batchKeySet = new HashSet();

    public void timeStep() {
        batchKeySet.clear();
        for(int i=0; i<batchSize; i++) {
            int k = random.nextInt(keyDomain);
            batchKeySet.add(k);
        }
        cache.getAll(batchKeySet);
    }
}