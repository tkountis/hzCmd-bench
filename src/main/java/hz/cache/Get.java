package hz.cache;

import hz.cache.base.CacheBench;

public class Get extends CacheBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        cache.get(k);
    }
}