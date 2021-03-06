package coherence;

import coherence.base.CacheBench;

public class Put extends CacheBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        Object key = getKey(k);
        Object val = mapKeyToValue(k);

        cache.put(key, val);
    }
}