package hz.map;

import com.hazelcast.core.HazelcastOverloadException;
import hz.map.base.MapBench;

public class GetAsync extends MapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        try{
            map.getAsync(k);
        }catch (HazelcastOverloadException e){}
    }
}