package hz.map;

import hz.map.base.MapBench;

public class RepeatGet extends MapBench {

    public double repeatProb=0.35;

    private Object previousKey=0;

    public void timeStep() {

        if(random.nextDouble() < repeatProb){
            map.get(previousKey);
        }else{
            Object k = randomKey();
            map.get(k);
            previousKey=k;
        }
    }
}