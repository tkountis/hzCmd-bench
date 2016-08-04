package hz.cache;

import com.hazelcast.cache.HazelcastExpiryPolicy;
import hz.cache.base.CacheBench;

import javax.cache.expiry.ExpiryPolicy;

public class PutTtl extends CacheBench {

    public long create=100;
    public long access=250;
    public long update=500;

    private  ExpiryPolicy p = new HazelcastExpiryPolicy(create, access, update);

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        Object v = mapKeyToValue(k);
        cache.put(k, v, p);
    }
}