package hz.map;

import com.hazelcast.core.HazelcastOverloadException;
import hz.map.base.MapBench;

public class GetAsync extends MapBench {

    public void timeStep() {
        try{
            map.getAsync(randomKey());
        }catch (HazelcastOverloadException e){}
    }
}