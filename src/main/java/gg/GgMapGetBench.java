package gg;

import org.apache.ignite.IgniteCache;

public class GgMapGetBench extends GgBench {

    protected IgniteCache<Object, Object> cache;
    public String name = "a";
    public int keyDomain = 10000;
    public int valueSize = 10;

    public byte[] value;

    public void setup(){
        value = new byte[valueSize];
        cache = ignite.getOrCreateCache(name);

        for(int i =0 ;i<keyDomain; i++){
            cache.put(i, value);
        }
    }

    @Override
    public void timeStep() {
        int k = random.nextInt(keyDomain);
        cache.put(k, value);
    }
}