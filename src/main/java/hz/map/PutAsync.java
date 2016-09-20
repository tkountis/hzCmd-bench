package hz.map;

import com.hazelcast.core.HazelcastOverloadException;
import hz.map.base.MapBench;

public class PutAsync extends MapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        Object key = getKey(k);
        Object val = mapKeyToValue(k);
        try{
            map.putAsync(key, val);
        }catch (HazelcastOverloadException e){}
    }
}