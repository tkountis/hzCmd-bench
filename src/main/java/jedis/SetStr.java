package jedis;

import jedis.base.JedisBench;

public class SetStr extends JedisBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);

        Object key = getKey(k);
        Object val = mapKeyToValue(k);

        jedisCluster.set(""+key, ""+val);
    }
}