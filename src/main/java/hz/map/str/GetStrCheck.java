package hz.map.str;

import global.AssertionException;
import hz.map.base.MapBench;

public class GetStrCheck extends MapBench {

    public void timeStep() throws AssertionException{
        Object key = randomKey();
        Object obj = map.get(""+randomKey());

        if(obj==null){
            throw new AssertionException("DATA LOSS! for map "+map.getName()+" key "+key);
        }
    }
}