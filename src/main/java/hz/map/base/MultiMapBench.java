package hz.map.base;

import base.BenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import javax.cache.CacheManager;

import static hz.utils.Utils.getCacheManager;

public abstract class MultiMapBench extends BenchBase {

    protected HazelcastInstance hzInstance;
    protected CacheManager cacheManager;

    public int count=10;
    private IMap[] maps;

    public void init() throws Exception {
        super.init();
        cacheManager = getCacheManager(hzInstance);

        maps = new IMap[count];

        for (int i = 0; i < count; i++) {
            maps[i] = hzInstance.getMap(name+i);
        }
    }

    public IMap getMap(){
        return maps[random.nextInt(count)];
    }

    public IMap[] getMaps(){
        return maps;
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }
}