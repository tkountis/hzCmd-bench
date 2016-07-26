package hz.cache;

import hz.cache.base.CacheBench;

public class Close extends CacheBench {
    public void timeStep() {
        cache.close();
    }
}