package jedis.base;

import base.StrKeyAllocation;
import redis.clients.jedis.JedisCluster;

public abstract class JedisBench extends StrKeyAllocation {

    protected JedisCluster jedisCluster;

    public void setVendorObject(Object vendorObject) { jedisCluster = (JedisCluster) vendorObject; }

}