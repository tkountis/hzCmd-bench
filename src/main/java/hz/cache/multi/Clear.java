package hz.cache.multi;

import hz.cache.base.MultiCacheBench;

public class Clear extends MultiCacheBench {
    public void timeStep() {
        getCache().clear();
    }
}