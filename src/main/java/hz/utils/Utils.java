package hz.utils;

import com.hazelcast.cache.ICache;
import com.hazelcast.cache.impl.HazelcastServerCachingProvider;
import com.hazelcast.cache.impl.nearcache.NearCache;
import com.hazelcast.cache.impl.nearcache.NearCacheManager;
import com.hazelcast.client.cache.impl.HazelcastClientCacheManager;
import com.hazelcast.client.cache.impl.HazelcastClientCachingProvider;
import com.hazelcast.config.CacheConfig;
import com.hazelcast.core.*;
import com.hazelcast.instance.HazelcastInstanceProxy;

import javax.cache.CacheManager;
import javax.cache.spi.CachingProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public abstract class Utils {

    public static int streamInAsyncCount=500;

    private static boolean isMember(HazelcastInstance instance) {
        return instance instanceof HazelcastInstanceProxy;
    }

    public static void sleepSeconds(int sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getUniqueKeyPrefix(HazelcastInstance hazelcastInstance){
        if (isMember(hazelcastInstance)){
            IAtomicLong count =  hazelcastInstance.getAtomicLong("m-");
            return "m"+count.getAndIncrement()+"-";
        }else{
            IAtomicLong count = hazelcastInstance.getAtomicLong("c-");
            return "c"+count.getAndIncrement()+"-";
        }
    }

    public static boolean localKey(int key, HazelcastInstance instance) {
        PartitionService partitionService = instance.getPartitionService();
        Partition partition = partitionService.getPartition(key);
        while (true) {
            Member owner = partition.getOwner();
            if (owner != null) {
                return owner.equals(instance.getLocalEndpoint());
            }
            sleepSeconds(1);
        }
    }

    public static boolean remoteKey(int key, HazelcastInstance instance) {
        return !localKey(key, instance);
    }



    public static NearCache getNearCache(CacheManager cacheManager, ICache cache){
        CacheConfig cacheConfig = (CacheConfig) cache.getConfiguration(CacheConfig.class);
        String cacheFullName = cacheConfig.getNameWithPrefix();

        HazelcastClientCacheManager clientCacheManager = (HazelcastClientCacheManager)cacheManager;
        NearCacheManager nearCacheManager = clientCacheManager.getNearCacheManager();
        NearCache nearCache = nearCacheManager.getNearCache(cacheFullName);
        return nearCache;
    }

    public static CacheManager getCacheManager(HazelcastInstance instance){
        CachingProvider provider;
        if (isMember(instance)) {
            provider = HazelcastServerCachingProvider.createCachingProvider(instance);
        } else {
            provider = HazelcastClientCachingProvider.createCachingProvider(instance);
        }
        return provider.getCacheManager(provider.getDefaultURI(),provider.getDefaultClassLoader(), null);
    }

}
