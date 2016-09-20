package jedis;

import jedis.base.JedisBench;

public class FillStr extends JedisBench {

    private int k=0;

    public void timeStep() {

        Object key = getKey(k);
        Object val = mapKeyToValue(k);

        jedisCluster.set(""+key, ""+val);
        k++;
    }

    public boolean isRunning() {
        return k<keyDomain;
    }
}