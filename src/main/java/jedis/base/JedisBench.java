package jedis.base;

import base.BenchBase;
import redis.clients.jedis.JedisCluster;

public abstract class JedisBench extends BenchBase {

    protected JedisCluster jedisCluster;

    public void setVendorObject(Object vendorObject) { jedisCluster = (JedisCluster) vendorObject; }

}