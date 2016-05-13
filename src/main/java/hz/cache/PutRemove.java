package hz.cache;

import hz.cache.base.CacheBench;

public class PutRemove extends CacheBench {

    public void timeStep() {
        int k = random.nextInt();
        int idx = random.nextInt(valueSetSize);
        byte[] v = valueSet.get(idx);
        cache.put(k, v);
        cache.remove(k);
    }
}