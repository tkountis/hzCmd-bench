package jedis;

import vendor.redis.RedisBench;

public class GetStrBench extends RedisBench {

    public String name;

    public int keyDomain = 10000;
    public int valueSize = 10;

    public byte[] value;

    public void setup(){
        value = new byte[valueSize];

        for(int i =0 ;i<keyDomain; i++){
            jedisCluster.set("" + i, "" + value);
        }
    }

    @Override
    public void timeStep() {
        int k = random.nextInt(keyDomain);
        jedisCluster.get(""+k);
    }
}