package jedis;


import jedis.base.JedisBench;

public class GetStr extends JedisBench {

    public void init() throws Exception{
        super.init();

        for(int i =0 ;i<keyDomain; i++){
            int idx = random.nextInt(valueSetSize);
            byte[] v = valueSet.get(idx);

            jedisCluster.set(""+i, ""+v);
        }
    }

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        jedisCluster.get("" + k);
    }

    public void cleanup() {

    }
}