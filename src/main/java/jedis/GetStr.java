package jedis;


import jedis.base.JedisBench;

public class GetStr extends JedisBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        jedisCluster.get(""+k);
    }
}