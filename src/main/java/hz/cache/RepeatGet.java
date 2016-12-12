package hz.cache;

import global.AssertionException;
import hz.cache.base.CacheBench;

public class RepeatGet extends CacheBench {

    public double repeatProb=0.85;

    private Object previousKey = randomKey();

    public void timeStep() throws AssertionException {
        Object val = null;
        if(random.nextDouble() < repeatProb){
            val = cache.get(previousKey);
        }else{
            Object k = randomKey();
            val = cache.get(k);
            previousKey=k;
        }

        if(val==null){
            throw new AssertionException(cache.getName()+" key "+previousKey+" == null");
        }
    }
}