package hz.cache;

import hz.cache.base.CacheBench;

public class GetClump extends CacheBench {

    public double repeatProb=0.35;

    private int previousKey=0;

    public void timeStep() {

        if(random.nextDouble() < repeatProb){
            cache.get(previousKey);
        }else{
            int k = random.nextInt(keyDomain);
            cache.get(k);
            previousKey=k;
        }
    }
}