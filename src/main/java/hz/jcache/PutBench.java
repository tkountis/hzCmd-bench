package hz.jcache;

import com.hazelcast.cache.ICache;
import com.hazelcast.core.IMap;
import hz.HzBench;

import javax.cache.CacheManager;
import java.util.ArrayList;
import java.util.List;

import static hz.utils.Utils.getCacheManager;
import static utils.Utils.dymanicValues;

public class PutBench extends HzBench {

    private ICache cache;
    public String name;
    public int keyDomain = Integer.MAX_VALUE;

    public int valueSetSize=1000;
    public int valueMinSize=250;
    public int valueMaxSize=6000;

    public List<byte[]> value;

    public void setup(){
        value = dymanicValues(valueSetSize, valueMinSize, valueMaxSize);

        CacheManager cacheManager = getCacheManager(hzInstance);
        cache = (ICache) cacheManager.getCache(name);
    }

    @Override
    public void timeStep() {
        int k = random.nextInt(keyDomain);
        int idx = random.nextInt(valueSetSize);
        byte[] v = value.get(idx);
        cache.put(k, v);
    }
}