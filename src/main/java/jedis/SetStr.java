package jedis;

import jedis.base.JedisBench;

public class SetStr extends JedisBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        int idx = random.nextInt(valueSetSize);
        byte[] v = valueSet.get(idx);
        jedisCluster.set(""+k, ""+v);
    }
}