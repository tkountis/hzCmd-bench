package hz.cache;

import hz.cache.base.CacheBench;

public class Cas extends CacheBench {

    public void timeStep() {
        Object k = randomKey();
        int value;
        do {
            value = (Integer) cache.get(k);
        }while (! cache.replace(k, value, ++value) );
    }

}