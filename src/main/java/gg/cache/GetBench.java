package gg.cache;

import vendor.gg.GgBench;
import org.apache.ignite.IgniteCache;

public class GetBench extends GgBench {

    protected IgniteCache<Object, Object> cache;
    public String name;
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
        cache.get(k);
    }
}