package jedis;

import jedis.base.JedisBench;

public class SetStr extends JedisBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);

        String key = (String)getKey(k);
        String val = (String)mapKeyToValue(k);

        jedisCluster.set(key, val);
    }
}