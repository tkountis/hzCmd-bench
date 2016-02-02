package gg.cache;

import gg.GgBench;
import org.apache.ignite.IgniteCache;

import java.util.List;

import static utils.Utils.dymanicValues;

public class PutBench extends GgBench {

    protected IgniteCache<Object, Object> cache;
    public String name = "a";
    public int keyDomain = Integer.MAX_VALUE;

    public int valueSetSize=1000;
    public int valueMinSize=250;
    public int valueMaxSize=6000;

    public List<byte[]> value;

    public void setup(){
        value = dymanicValues(valueSetSize, valueMinSize, valueMaxSize);
        cache = ignite.getOrCreateCache(name);
    }

    @Override
    public void timeStep() {
        int k = random.nextInt(keyDomain);
        int idx = random.nextInt(valueSetSize);
        byte[] v = value.get(idx);
        cache.put(k, v);
    }
}