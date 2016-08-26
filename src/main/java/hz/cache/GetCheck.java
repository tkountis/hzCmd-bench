package hz.cache;

import global.AssertionException;
import hz.cache.base.CacheBench;


public class GetCheck extends CacheBench {

    public void timeStep() throws AssertionException {
        int k = random.nextInt(keyDomain);
        Object obj = cache.get(k);

        if(obj==null){
            throw new AssertionException("DATA LOSS! for key "+k);
        }
    }

}