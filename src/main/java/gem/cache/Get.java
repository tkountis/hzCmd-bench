package gem.cache;

import gem.cache.base.RegionBench;

public class Get extends RegionBench {

    public void init() {
        super.init();

        for(int i =0 ;i<keyDomain; i++){
            int idx = random.nextInt(valueSetSize);
            byte[] v = valueSet.get(idx);
            region.put(i, v);
        }
    }

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        region.get(k);
    }
}