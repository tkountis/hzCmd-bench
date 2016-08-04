package hz.cache;

import hz.cache.base.CacheBench;

public class Remove extends CacheBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        cache.remove(k);
    }
}