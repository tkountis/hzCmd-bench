package jedis;

import jedis.base.JedisBench;

public class FillStr extends JedisBench {

    private int k=0;

    public void timeStep() {

        String key = (String)getKey(k);
        String val = (String)mapKeyToValue(k);

        jedisCluster.set(key, val);
        k++;
    }

    public boolean isRunning() {
        return k<keyDomain;
    }
}