package hz.map;

import global.AssertionException;
import hz.map.base.MapBench;


public class GetCheck extends MapBench {

    public void timeStep() throws AssertionException {
        Object k = randomKey();
        Object obj = map.get(k);

        if(obj==null){
            throw new AssertionException("DATA LOSS! for map "+map.getName()+" key "+k);
        }
    }

}