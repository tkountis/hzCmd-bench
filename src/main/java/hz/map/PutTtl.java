package hz.map;

import hz.map.base.MapBench;

import java.util.concurrent.TimeUnit;

public class PutTtl extends MapBench {

    public int ttl=1;

    public void timeStep() {
        int k = random.nextInt(keyDomain);

        Object key = getKey(k);
        Object val = mapKeyToValue(k);
        map.put(key, val, ttl, TimeUnit.SECONDS);
    }

}