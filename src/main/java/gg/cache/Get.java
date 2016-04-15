package gg.cache;

import gg.cache.base.CacheBench;

public class Get extends CacheBench {

    public void setup(){
        for(int i =0 ;i<keyDomain; i++){
            int idx = random.nextInt(valueSetSize);
            byte[] v = valueSet.get(idx);
            cache.put(i, v);
        }
    }

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        cache.get(k);
    }
}