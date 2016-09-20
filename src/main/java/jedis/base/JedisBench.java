package jedis.base;

import base.StrZeroAllocation;
import redis.clients.jedis.JedisCluster;

public abstract class JedisBench extends StrZeroAllocation {

    protected JedisCluster jedisCluster;

    public void setVendorObject(Object vendorObject) { jedisCluster = (JedisCluster) vendorObject; }

}