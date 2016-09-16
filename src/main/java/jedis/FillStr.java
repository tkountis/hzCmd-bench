package jedis;

import jedis.base.JedisBench;

public class FillStr extends JedisBench {

    public void timeStep() {
        for(int k=0; k<keyDomain; k++){
            Object v = mapKeyToValue(k);
            jedisCluster.set(""+k, ""+v);
        }
        setRunning(false);
    }
}