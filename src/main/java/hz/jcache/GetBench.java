package hz.jcache;

import com.hazelcast.cache.ICache;
import vendor.hz.HzBench;

import javax.cache.CacheManager;

import static hz.utils.Utils.getCacheManager;

public class GetBench extends HzBench {

    private ICache cache;
    public String name;

    public int keyDomain = 10000;
    public int valueSize = 10;

    public byte[] value;

    public void setup(){
        value = new byte[valueSize];

        CacheManager cacheManager = getCacheManager(hzInstance);
        cache = (ICache) cacheManager.getCache(name);

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