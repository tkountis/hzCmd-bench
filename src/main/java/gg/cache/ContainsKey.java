package gg.cache;

import gg.cache.base.CacheBench;

public class ContainsKey extends CacheBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        cache.containsKey(k);
    }
}