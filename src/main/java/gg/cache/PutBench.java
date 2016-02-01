package gg.cache;

import gg.GgBench;
import org.apache.ignite.IgniteCache;

public class PutBench extends GgBench {

    protected IgniteCache<Object, Object> cache;
    public String name = "a";
    public int keyDomain = 10000;
    public int valueSize = 10;

    public byte[] value;

    public void setup(){
        value = new byte[valueSize];
        cache = ignite.getOrCreateCache(name);
    }

    @Override
    public void timeStep() {
        int k = random.nextInt(keyDomain);
        cache.put(k, value);
    }
}