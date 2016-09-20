package hz.cache;

import hz.cache.base.CacheBench;

public class Remove extends CacheBench {

    public void timeStep() {
        cache.remove(randomKey());
    }
}