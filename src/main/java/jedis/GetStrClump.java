package jedis;

import jedis.base.JedisBench;

public class GetStrClump extends JedisBench {

    public int repeatGet=3;
    private int getCount=1;

    public void init() {
        super.init();

        for(int i =0 ;i<keyDomain; i++){
            int idx = random.nextInt(valueSetSize);
            byte[] v = valueSet.get(idx);
            jedisCluster.set(""+i, ""+v);
        }
    }

    public void timeStep() {
        int k = random.nextInt(keyDomain);

        if(k%2==0){
            getCount=repeatGet;
        }else{
            getCount=1;
        }

        for(int i=0; i<getCount; i++){
            jedisCluster.get("" + k);
        }
    }

    public void cleanup() {

    }
}