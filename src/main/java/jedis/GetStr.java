package jedis;


import jedis.base.JedisBench;

public class GetStr extends JedisBench {

    public void timeStep() {
        jedisCluster.get((String)randomKey());
    }
}