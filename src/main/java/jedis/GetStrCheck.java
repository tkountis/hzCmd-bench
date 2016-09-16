package jedis;

import global.AssertionException;
import jedis.base.JedisBench;


public class GetStrCheck extends JedisBench {

    public void timeStep() throws AssertionException {
        int k = random.nextInt(keyDomain);
        String val = jedisCluster.get(""+k);

        if(val==null || "".equals(val)){
            throw new AssertionException("DATA LOSS! for "+jedisCluster+" key "+k);
        }
    }

}