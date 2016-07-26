package hz.cache;

import hz.cache.base.CacheBench;

public class Clear extends CacheBench {
    public void timeStep() {
        cache.clear();
    }
}