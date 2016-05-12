package hz.cache;

import hz.cache.base.CacheBench;

public class ContainsKey extends CacheBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        cache.containsKey(k);
    }
}