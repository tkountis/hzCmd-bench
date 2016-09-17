package jedis;

import jedis.base.JedisBench;

public class FillStr extends JedisBench {

    private int key=0;

    public void timeStep() {
        Object v = mapKeyToValue(key);
        jedisCluster.set(""+key, ""+v);
        key++;
    }

    public boolean isRunning() {
        return key<keyDomain;
    }
}