package hz.utils;

import com.hazelcast.cache.impl.HazelcastServerCachingProvider;
import com.hazelcast.client.cache.impl.HazelcastClientCachingProvider;
import com.hazelcast.core.*;
import com.hazelcast.instance.HazelcastInstanceProxy;

import javax.cache.CacheManager;
import javax.cache.spi.CachingProvider;

import static utils.Utils.sleep;

public abstract class Utils {

    private static boolean isMember(HazelcastInstance instance) {
        return instance instanceof HazelcastInstanceProxy;
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

    public static boolean localKey(Object key, HazelcastInstance instance) {
        PartitionService partitionService = instance.getPartitionService();
        Partition partition = partitionService.getPartition(key);
        while (true) {
            Member owner = partition.getOwner();
            if (owner != null) {
                return owner.equals(instance.getLocalEndpoint());
            }
            sleep(20);
        }
    }

    public static boolean remoteKey(Object key, HazelcastInstance instance) {
        return !localKey(key, instance);
    }


    public static void warmupPartitions(HazelcastInstance hz) {
        PartitionService partitionService = hz.getPartitionService();
        for (Partition partition : partitionService.getPartitions()) {

            while (partition.getOwner() == null) {
                sleep(20);
            }
        }
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
