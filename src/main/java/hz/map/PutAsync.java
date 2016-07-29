package hz.map;

import com.hazelcast.core.HazelcastOverloadException;
import hz.map.base.MapBench;

public class PutAsync extends MapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        Object v = mapKeyToValue(k);
        try{
            map.putAsync(k, v);
        }catch (HazelcastOverloadException e){}
    }
}