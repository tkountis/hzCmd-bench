package jedis;

import global.AssertionException;
import jedis.base.JedisBench;


public class GetStrCheck extends JedisBench {

    public void timeStep() throws AssertionException {
        String key = (String)randomKey();
        String val = jedisCluster.get(key);

        if(val==null){
            throw new AssertionException("DATA LOSS! for "+jedisCluster+" key "+key);
        }
    }

}