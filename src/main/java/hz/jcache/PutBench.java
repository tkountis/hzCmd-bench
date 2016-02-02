package hz.jcache;

import com.hazelcast.cache.ICache;
import com.hazelcast.core.IMap;
import hz.HzBench;

import javax.cache.CacheManager;
import java.util.ArrayList;
import java.util.List;

import static hz.utils.Utils.getCacheManager;

public class PutBench extends HzBench {

    private ICache cache;
    public String name = "a";

    public int keyDomain = 10000;
    public int valueSize = 10;

    public byte[] value;

    public void setup(){
        value = new byte[valueSize];

        CacheManager cacheManager = getCacheManager(hzInstance);
        cache = (ICache) cacheManager.getCache(name);
    }

    @Override
    public void timeStep() {
        int k = random.nextInt(keyDomain);
        cache.put(k, value);
    }
}