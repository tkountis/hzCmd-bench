package hz.cache;

import hz.cache.base.CacheBench;

public class Get extends CacheBench {

    public void timeStep() {
        cache.get(randomKey());
    }
}