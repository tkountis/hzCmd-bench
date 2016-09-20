package jedis;

import global.AssertionException;
import jedis.base.JedisBench;


public class GetStrCheck extends JedisBench {

    public void timeStep() throws AssertionException {
        int k = random.nextInt(keyDomain);
        Object key = getKey(k);
        String val = jedisCluster.get(""+key);

        if(val==null){
            throw new AssertionException("DATA LOSS! for "+jedisCluster+" key "+key);
        }
    }

}