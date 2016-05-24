package hz.cache;

import hz.cache.base.CacheBench;

public class PutRemove extends CacheBench {

    public void timeStep() {
        int k = random.nextInt();
        Object v = mapKeyToValue(k);
        cache.put(k, v);
        cache.remove(k);
    }
}