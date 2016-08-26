package hz.cache;

import hz.cache.base.CacheBench;

public class Cas extends CacheBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        int value;
        do {
            value = (Integer) cache.get(k);
        }while (! cache.replace(k, value, ++value) );
    }

}