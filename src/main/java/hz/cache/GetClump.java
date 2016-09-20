package hz.cache;

import hz.cache.base.CacheBench;

public class GetClump extends CacheBench {

    public double repeatProb=0.35;

    private Object previousKey;

    public void timeStep() {

        if(random.nextDouble() < repeatProb){
            cache.get(previousKey);
        }else{
            Object k = randomKey();
            cache.get(k);
            previousKey=k;
        }
    }
}