package coherence;

import coherence.base.CacheBench;

public class Fill extends CacheBench {

    private int k=0;

    public void timeStep() {
        Object key = getKey(k);
        Object val = mapKeyToValue(k);
        cache.put(key, val);
        k++;
    }

    public boolean isRunning() {
        return k<keyDomain;
    }
}