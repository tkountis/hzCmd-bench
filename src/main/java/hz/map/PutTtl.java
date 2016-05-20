package hz.map;

import hz.map.base.MapBench;

import java.util.concurrent.TimeUnit;

public class PutTtl extends MapBench {

    public int ttl=1;

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        int idx = random.nextInt(valueSetSize);
        byte[] v = valueSet.get(idx);
        map.put(k, v, ttl, TimeUnit.SECONDS);
    }

}