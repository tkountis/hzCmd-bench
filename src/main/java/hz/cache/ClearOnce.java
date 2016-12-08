package hz.cache;

import hz.cache.base.CacheBench;

public class ClearOnce extends CacheBench {
    public void timeStep() {
        cache.clear();
        setRunning(false);
    }
}