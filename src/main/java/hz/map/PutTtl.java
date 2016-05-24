package hz.map;

import hz.map.base.MapBench;

import java.util.concurrent.TimeUnit;

public class PutTtl extends MapBench {

    public int ttl=1;

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        Object v = mapKeyToValue(k);
        map.put(k, v, ttl, TimeUnit.SECONDS);
    }

}