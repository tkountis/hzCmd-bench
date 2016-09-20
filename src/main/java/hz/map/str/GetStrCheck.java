package hz.map.str;

import global.AssertionException;
import hz.map.str.base.StrMapBench;

public class GetStrCheck extends StrMapBench {

    public void timeStep() throws AssertionException{
        String key = (String) randomKey();
        String obj = (String) map.get(key);

        if(obj==null){
            throw new AssertionException("DATA LOSS! for map "+map.getName()+" key "+key);
        }
    }
}